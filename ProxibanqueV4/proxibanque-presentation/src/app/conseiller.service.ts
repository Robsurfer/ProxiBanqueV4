import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Injectable } from '@angular/core';

import { Employe } from './conseiller';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { LoginService } from './login.service';
//Pour l'update
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ConseillerService {
// URL vers le web service
  private conseillersUrl = 'http://localhost:8082//listeConseillers'; 

  constructor(
      private http: HttpClient,
      private loginService: LoginService
  ){}

  getConseillers (): Observable<Employe[]> {
    return this.http.get<Employe[]>(this.conseillersUrl)
      .pipe(
        catchError(this.handleError('getConseillers', []))
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
