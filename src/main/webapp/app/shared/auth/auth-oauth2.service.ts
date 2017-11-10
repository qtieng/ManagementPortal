import { Injectable, Inject } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';

import {CookieService} from "angular2-cookie/core";
import {Router} from "@angular/router";

@Injectable()
export class AuthServerProvider {

    constructor(
        private http: Http,
        private cookieService : CookieService,
        private router: Router,
    ) {}

    getToken() {
        return this.cookieService.getObject('authenticationToken');
    }

    login(credentials): Observable<any> {
        const data = 'username=' +  encodeURIComponent(credentials.username) + '&password=' +
            encodeURIComponent(credentials.password) + '&grant_type=password&scope=read%20write';

        this.cookieService.putObject('rememberMe' , credentials.rememberMe);

        const headers = new Headers ({
            'Content-Type': 'application/x-www-form-urlencoded',
            'Accept': 'application/json'
        });

        return this.http.post('oauthserver/oauth/token', data, {
            headers: headers
        }).map(authSuccess.bind(this));

        function authSuccess(resp) {
            const response = resp.json();
            const expiredAt = new Date();
            expiredAt.setSeconds(expiredAt.getSeconds() + response.expires_in);
            response.expires_at = expiredAt.getTime();
            this.cookieService.putObject('authenticationToken', response);

            return response;
        }
    }

    // refreshToken(): Observable<Response> {
    //
    //     this.sendRefreshTokenRequest().subscribe((resp) => {
    //         const response = resp.json();
    //         if (typeof response.access_token !== 'undefined') {
    //             const expiredAt = new Date();
    //             expiredAt.setSeconds(expiredAt.getSeconds() + response.expires_in);
    //             response.expires_at = expiredAt.getTime();
    //             this.cookieService.remove('authenticationToken');
    //             this.cookieService.putObject('authenticationToken', response);
    //             console.log("refreshed");
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     });
    //
    // }

    sendRefreshTokenRequest(): Observable<Response> {
        const headers = new Headers({
            'Content-Type': 'application/x-www-form-urlencoded',
            'Accept': 'application/json'
        });
        const refreshData = 'grant_type=refresh_token';
        return this.http.post('oauthserver/oauth/token', refreshData, {
            headers: headers
        });
    }

    logout(): Observable<any> {
        console.log("called");
        return new Observable(observer => {
            this.http.post('api/logout', {});
            const headers = new Headers({
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept': 'application/json'
            });
            const refreshData = 'grant_type=refresh_token';
            this.http.delete('oauthserver/oauth/token', { headers: headers} );
            this.cookieService.removeAll();
            // this.$localStorage.clear('authenticationToken');
            observer.complete();
        });
    }
}
