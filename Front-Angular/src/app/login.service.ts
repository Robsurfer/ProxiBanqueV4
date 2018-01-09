import { Injectable } from '@angular/core';
import { Conseiller } from './conseiller';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators/catchError';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {

  private loginUrl = 'http://localhost:8082/login';

  constructor(
    private http: HttpClient,
  ){}

  authentification(conseiller:Conseiller): Observable<Conseiller> {
    
    
    console.log(conseiller);
    console.log("Début de la requête http");
    return this.http.post<Conseiller>(this.loginUrl, conseiller, httpOptions).pipe(
      catchError(this.handleError<Conseiller>('authentification'))
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
