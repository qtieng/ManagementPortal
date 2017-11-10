import { Injector } from '@angular/core';
import { Http, XHRBackend, RequestOptions } from '@angular/http';
import { EventManager, InterceptableHttp } from 'ng-jhipster';

import { AuthInterceptor } from './auth.interceptor';
import { AuthExpiredInterceptor } from './auth-expired.interceptor';
import { ErrorHandlerInterceptor } from './errorhandler.interceptor';
import { NotificationInterceptor } from './notification.interceptor';
import {CookieService} from "angular2-cookie/core";
import {JhiInterceptableHttp} from "./interceptable.http";

export function interceptableFactory(
    backend: XHRBackend,
    defaultOptions: RequestOptions,
    cookieService: CookieService,
    injector: Injector,
    eventManager: EventManager
) {
    return new JhiInterceptableHttp(
        backend,
        defaultOptions,
        injector,
        [
            new AuthInterceptor(injector),
            new AuthExpiredInterceptor(injector),
            // Other interceptors can be added here
            new ErrorHandlerInterceptor(eventManager),
            new NotificationInterceptor()
        ]
    );
};

export function customHttpProvider() {
    return {
        provide: Http,
        useFactory: interceptableFactory,
        deps: [
            XHRBackend,
            RequestOptions,
            CookieService,
            Injector,
            EventManager
        ]
    };
};
