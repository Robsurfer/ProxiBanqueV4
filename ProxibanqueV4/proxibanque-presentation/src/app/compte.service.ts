import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Injectable } from '@angular/core';

import { Compte } from './compte';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { LoginService } from './login.service';
import { WebserviceService } from './webservice.service';
//Pour l'update
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class CompteService {
// URL vers le web service
  private comptesUrl = this.webService.getRootUrl()+'conseiller/'+ this.loginService.getLoginEmployeSession() + '/comptes'; 
  private comptesAgenceUrl = this.webService.getRootUrl()+'comptes'; 
  constructor(
      private http: HttpClient,
      private loginService: LoginService, 
      private webService : WebserviceService
  ){}

  getComptes (): Observable<Compte[]> {
    return this.http.get<Compte[]>(this.comptesUrl)
      .pipe(
        catchError(this.handleError('getComptes', []))
      );
  }

  getComptesAgence (): Observable<Compte[]> {
    return this.http.get<Compte[]>(this.comptesAgenceUrl)
      .pipe(
        catchError(this.handleError('getComptesAgence', []))
      );
  }

  getCompte(id: number): Observable<Compte[]> {
    const url = `${this.comptesUrl}/client/${id}`;
    return this.http.get<Compte[]>(url).pipe(
      catchError(this.handleError<Compte[]>(`getCompte id=${id}`))
    );
  }

  getCompteNumero(numero: number): Observable<Compte> {
    const url = `${this.comptesAgenceUrl}/${numero}`;
    return this.http.get<Compte>(url).pipe(
      catchError(this.handleError<Compte>('getCompteNumero numero=${numero}'))
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
