import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { catchError, map } from 'rxjs/operators';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { Compte } from './compte';

@Injectable()
export class CompteService {

  //URL pour web app
  private compteURL = 'http://localhost:8082/'

  constructor
  (
    private http: HttpClient
  ) { }

  /** GET compte from the server */
  getComptes(): Observable<Compte[]>
  {
    return this.http.get<Compte[]>(this.compteURL)
      .pipe(
        catchError(this.handleError('getComptes', []))
      );
  }



 /**
 * Handle Http operation that failed.
 * Let the app continue.
 * @param operation - name of the operation that failed
 * @param result - optional value to return as the observable result
 */
 private handleError<T> (operation = 'operation', result?: T)
 {
   return (error:any): Observable<T> =>
   {
     // TODO: send the error to remote logging infrastructure
     console.error(error); //log to console instead

     // Let the app keep running by returning an empty result
     return of(result as T);
   };
 }

}
