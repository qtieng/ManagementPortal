/*
 Copyright 2013-2017 the original author or authors from the JHipster project.
 This file is part of the JHipster project, see https://jhipster.github.io/
 for more information.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
import { JhiHttpInterceptor } from './http.interceptor';
import {forwardRef, Inject, Injectable, Injector} from '@angular/core';
import { Http, ConnectionBackend, RequestOptions, RequestOptionsArgs, RequestMethod, Request, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {CookieService} from "angular2-cookie/core";
import {AuthServerProvider} from "../../shared/index";

@Injectable()
export class JhiInterceptableHttp extends Http {

    private firstInterceptor: JhiHttpInterceptor;

    constructor(
        private backend: ConnectionBackend,
        private defaultOptions: RequestOptions,
        private injector: Injector,
        @Inject(forwardRef(() => JhiHttpInterceptor)) interceptors: JhiHttpInterceptor[] // see the issue generator-jhipster#4794
    ) {
        super(backend, defaultOptions);

        /**
         * building a responsibility chain of http interceptors, so when processXXXInterception is called on first interceptor,
         * all http interceptors are called in a row
         * Note: the array of interceptors are wired in customHttpProvider of the generated Jhipster app in file `http.provider.ts`
         *
         */
        if (interceptors && interceptors.length > 0) {
            interceptors.reduce((chain, current) => {
                chain.successor = current;
                return current;
            });

            this.firstInterceptor = interceptors[0];
        }
    }

    request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {
        // Response interceptor needs to be called only once after the final request here
        // Every HTTP method will go through this request method
        console.log("Called with " , url)
        const response = super.request(url, options).catch(
            (err) => {
                if (err.status === 401) {
                    console.log('request...', url);
                    const cookieService = this.injector.get(CookieService);
                    const authServerProvider = this.injector.get(AuthServerProvider);
                    const rememberMe: any = cookieService.getObject('rememberMe');
                    if (rememberMe && rememberMe === true) {
                        console.log("remember me");

                        authServerProvider.sendRefreshTokenRequest().subscribe(res => {
                            if(res.status === 200) {
                                const response = res.json();
                                const expiredAt = new Date();
                                expiredAt.setSeconds(expiredAt.getSeconds() + response.expires_in);
                                response.expires_at = expiredAt.getTime();
                                cookieService.remove('authenticationToken');
                                cookieService.putObject('authenticationToken', response);
                                console.log("Done");
                                if (options) {
                                    options = {headers: new Headers()};
                                    options.headers.append('Authorization' , 'Bearer '+ response.access_token)

                                }
                                if(  typeof(url) === 'object') {
                                    console.log("request url" , url);
                                    url.headers.append('Authorization' , 'Bearer '+ response.access_token)
                                }

                                return this.request(url, options);
                            }

                        });
                    }
                    else {
                        authServerProvider.logout();
                        return Observable.throw(err);
                    }

                }
                return Observable.throw(err);
            }
        );

        return this.interceptResponse(url, response);
    }

    get(url: string, options?: RequestOptionsArgs): Observable<Response> {
        console.log("get")
        return super.get(url, this.interceptRequest(url, RequestMethod.Get, options));
    }

    post(url: string, body: string, options?: RequestOptionsArgs): Observable<Response> {
        console.log("post")
        return super.post(url, body, this.interceptRequest(url, RequestMethod.Post, options, body));
    }

    put(url: string, body: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.put(url, body, this.interceptRequest(url, RequestMethod.Put, options, body));
    }

    delete(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.delete(url, this.interceptRequest(url, RequestMethod.Delete, options));
    }

    patch(url: string, body: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.patch(url, body, this.interceptRequest(url, RequestMethod.Patch, options, body));
    }

    head(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.head(url, this.interceptRequest(url, RequestMethod.Head, options));
    }

    options(url: string, options?: RequestOptionsArgs): Observable<Response> {
        return super.options(url, this.interceptRequest(url, RequestMethod.Options, options));
    }

    interceptRequest(url: string, method: RequestMethod, options?: RequestOptionsArgs, body?: any): RequestOptionsArgs {
        console.log("intercept")
        if (!options) {
            options = new RequestOptions();
        }

        if (!options.headers) {
            options.headers = new Headers();
        }

        options.url = options.url || url;
        options.method = options.method || method;
        options.body = options.body || body;

        return !this.firstInterceptor ? options : this.firstInterceptor.processRequestInterception(options);
    }

    interceptResponse(url : string | Request, observable : Observable<Response>): Observable<Response> {
        return !this.firstInterceptor ? observable : this.firstInterceptor.processResponseInterception(url, observable);
    }
}/**
 * Created by nivethika on 10-11-17.
 */
