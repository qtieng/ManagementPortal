import { HttpInterceptor, EventManager } from 'ng-jhipster';
import { RequestOptionsArgs, Response , Request} from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {JhiHttpInterceptor} from "./http.interceptor";

export class ErrorHandlerInterceptor extends JhiHttpInterceptor {

    constructor(private eventManager: EventManager) {
        super();
    }

    requestIntercept(options?: RequestOptionsArgs): RequestOptionsArgs {
        return options;
    }

    responseIntercept( url : string | Request, observable: Observable<Response>): Observable<Response>{
        return <Observable<Response>> observable.catch((error) => {
            if (!(error.status === 401 && (error.text() === '' ||
                (error.json().path && error.json().path.indexOf('/api/account') === 0 )))) {
                this.eventManager.broadcast( {name: 'managementPortalApp.httpError', content: error});
            }
            return Observable.throw(error);
        });
    }
}
