// import {Injectable, Injector} from '@angular/core';
// import { Http, ConnectionBackend, Request, RequestOptions, RequestOptionsArgs, Response, Headers } from '@angular/http';
// import { Observable } from 'rxjs/Observable';
// import {HttpInterceptor, InterceptableHttp} from "ng-jhipster";
// import {CookieService} from "angular2-cookie/core";
// import {AuthServerProvider} from "../../shared/auth/auth-oauth2.service";
// import {JhiInterceptableHttp} from "./interceptable.http";
// import {JhiHttpInterceptor} from "./http.interceptor";
// @Injectable()
// export class CustomInterceptableHttp extends JhiInterceptableHttp {
//
//     constructor(
//         private backend: ConnectionBackend,
//         private defaultOptions: RequestOptions,
//         private interceptors: JhiHttpInterceptor[],
//         private  injector: Injector) {
//         super(backend, defaultOptions, injector, interceptors );
//     }
//     request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {
//
//         console.log("Called ", url);
//         console.log(" options ", options);
//          return super.request(url, options).catch(
//             (err) => {
//                 if (err.status === 401) {
//                     console.log('request...', url);
//                     const cookieService = this.injector.get(CookieService);
//                     const authServerProvider = this.injector.get(AuthServerProvider);
//                     const rememberMe: any = cookieService.getObject('rememberMe');
//                     if (rememberMe && rememberMe === true) {
//                         console.log("remember me");
//
//                         authServerProvider.sendRefreshTokenRequest().subscribe(res => {
//                             if(res.status === 200) {
//                                 const response = res.json();
//                                 const expiredAt = new Date();
//                                 expiredAt.setSeconds(expiredAt.getSeconds() + response.expires_in);
//                                 response.expires_at = expiredAt.getTime();
//                                 cookieService.remove('authenticationToken');
//                                 cookieService.putObject('authenticationToken', response);
//
//                                 if (!options) {
//                                     options = {headers: new Headers()};
//                                     options.headers.append('Authorization' , 'Bearer '+ response.access_token)
//
//                                 }
//                                 return this.request(url, options);
//                             }
//
//                         });
//                     }
//                     else {
//                         authServerProvider.logout();
//                         return Observable.throw(err);
//                     }
//                 }
//
//             }
//         );
//     }
//
//
// }
