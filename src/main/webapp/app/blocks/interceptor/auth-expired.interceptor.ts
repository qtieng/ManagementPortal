import { RequestOptionsArgs, Response, Request } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Injector } from '@angular/core';
import { AuthService } from '../../shared/auth/auth.service';
import { Principal } from '../../shared/auth/principal.service';
import { AuthServerProvider } from '../../shared/auth/auth-oauth2.service';
import {JhiHttpInterceptor} from "./http.interceptor";

export class AuthExpiredInterceptor extends JhiHttpInterceptor {

    constructor(private injector: Injector) {
        super();
    }

    requestIntercept(options?: RequestOptionsArgs): RequestOptionsArgs {
        return options;
    }

    responseIntercept( url : string | Request, observable: Observable<Response>): Observable<Response>{
        console.log("respose inte" , url);

        return <Observable<Response>> observable.catch((error, source) => {
            console.log("resp int " , error);
            if (error.status === 401) {

                const principal: Principal = this.injector.get(Principal);
                if (principal.isAuthenticated()) {
                    const auth: AuthService = this.injector.get(AuthService);
                    auth.authorize(true);
                } else {
                    const authServerProvider: AuthServerProvider = this.injector.get(AuthServerProvider);
                    authServerProvider.logout();
                }

            }
            return Observable.throw(error);
        });
    }
}
