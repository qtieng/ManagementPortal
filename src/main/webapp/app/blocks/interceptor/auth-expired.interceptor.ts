import { RequestOptionsArgs, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Injector } from '@angular/core';
import { AuthService } from '../../shared/auth/auth.service';
import { Principal } from '../../shared/auth/principal.service';
import { AuthServerProvider } from '../../shared/auth/auth-oauth2.service';
import {HttpInterceptor} from "ng-jhipster";
import {Router} from "@angular/router";

export class AuthExpiredInterceptor extends HttpInterceptor {

    constructor(private injector: Injector) {
        super();
    }

    requestIntercept(options?: RequestOptionsArgs): RequestOptionsArgs {
        return options;
    }

    responseIntercept(observable: Observable<Response>): Observable<Response> {
        return <Observable<Response>> observable.catch((error, source) => {
            if (error.status === 401) {
                const principal: Principal = this.injector.get(Principal);
                const authServerProvider: AuthServerProvider = this.injector.get(AuthServerProvider);
                authServerProvider.refreshToken();

                // {
                    const router = this.injector.get(Router);
                    let url = error.body;
                    observable.subscribe(res => {console.log("res ", res.json())});
                    router.navigate([url]);
                // }// refreshes, but cannot try the request again, since we are already at response.
                // else {
                // if (principal.isAuthenticated()) {
                //     const auth: AuthService = this.injector.get(AuthService);
                //     auth.authorize(true);
                // } else {
                //
                //     authServerProvider.logout();
                // }
                // }
            }
            return Observable.throw(error);
        });
    }
}
