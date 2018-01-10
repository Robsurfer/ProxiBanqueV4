import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Injectable } from '@angular/core';

import { VirementFormulaire } from './virement-formulaire';
//import { Virement } from './virement';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { LoginService } from './login.service';
//Pour l'update
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

const httpOptionsPOST = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Accept' : 'text/plain, application/json' })
};
@Injectable()
export class VirementService {

    // URL vers le web service
    private virementsUrl = 'http://localhost:8082/conseiller/'+ this.loginService.getLoginEmployeSession() + '/virement/liste'; 
    private creationVirementsUrl = 'http://localhost:8082/conseiller/'+ this.loginService.getLoginEmployeSession() + '/virement';

    constructor(
        private http: HttpClient,
        private loginService: LoginService
    ){}

  addVirement (virement: VirementFormulaire): Observable<string>{
    return this.http.post(this.creationVirementsUrl, virement, { responseType: 'text' }).pipe(
      catchError(this.handleError<string>('addVirement'))
    );
  }

  

  /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
 private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
