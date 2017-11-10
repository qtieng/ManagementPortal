import { HttpInterceptor } from 'ng-jhipster';
import { RequestOptionsArgs, Response , Request } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {JhiHttpInterceptor} from "./http.interceptor";

export class NotificationInterceptor extends JhiHttpInterceptor {

    constructor() {
        super();
    }

    requestIntercept(options?: RequestOptionsArgs): RequestOptionsArgs {
        return options;
    }

    responseIntercept(url : string | Request, observable: Observable<Response>): Observable<Response> {
        return <Observable<Response>> observable.catch((error) => {
            const arr = Array.from(error.headers._headers);
            const headers = [];
            let i;
            for (i = 0; i < arr.length; i++) {
                if (arr[i][0].endsWith('app-alert') || arr[i][0].endsWith('app-params')) {
                    headers.push(arr[i][0]);
                }
            }
            headers.sort();
            const alertKey = headers.length >= 1 ? error.headers.get(headers[0]) : null;
            if (typeof alertKey === 'string') {
                // AlertService.success(alertKey, { param: response.headers(headers[1])});
            }
            return Observable.throw(error);
        });
    }
}
