import { Observable } from 'rxjs/Observable';
import { RequestOptionsArgs, Response , Request} from '@angular/http';
import { HttpInterceptor } from 'ng-jhipster';
import {CookieService} from "angular2-cookie/core";
import {Injector} from "@angular/core";
import {AuthServerProvider} from "../../shared/auth/auth-oauth2.service";
import {JhiHttpInterceptor} from "./http.interceptor";

export class AuthInterceptor extends JhiHttpInterceptor {

    constructor(
        private injector: Injector,
    ) {
        super();
    }

    requestIntercept(options?: RequestOptionsArgs): RequestOptionsArgs {
        const cookieService = this.injector.get(CookieService);
        const token : any = cookieService.getObject('authenticationToken');
        if (token && token.expires_at && token.expires_at > new Date().getTime()) {
            options.headers.append('Authorization', 'Bearer ' + token.access_token);
        }
        return options;
    }

    responseIntercept( url : string | Request, observable: Observable<Response>): Observable<Response>{
        return observable; // by pass
    }

}
