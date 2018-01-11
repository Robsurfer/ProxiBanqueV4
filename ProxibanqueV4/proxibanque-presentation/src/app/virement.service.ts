import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Injectable } from '@angular/core';

import { VirementFormulaire } from './virement-formulaire';
import { Virement } from './virement';

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

  /** GET listeVirements from the server */
  getVirementsConseiller (): Observable<Virement[]> {
    console.log(this.http.get<Virement[]>(this.virementsUrl));
    console.log(this.loginService.getLoginEmployeSession());
    return this.http.get<Virement[]>(this.virementsUrl)
      .pipe(
        catchError(this.handleError('getVirementConseillers', []))
      );
  }

  /** GET listeVirements from the server */
  getVirementsAgence(): Observable<Virement[]> {
    var date1= '12012018';
    var date2= '01092017';
    var listeVirementsAgenceUrl = 'http://localhost:8082/gerant/audit/'+date1+"/"+date2;

    return this.http.get<Virement[]>(listeVirementsAgenceUrl)
      .pipe(
        catchError(this.handleError('getVirementConseillers', []))
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
