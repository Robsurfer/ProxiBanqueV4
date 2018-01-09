import { Injectable } from '@angular/core';
import { Conseiller } from './conseiller';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of } from 'rxjs/observable/of';
import { catchError } from 'rxjs/operators/catchError';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {

  private loginUrl = 'http://localhost:8082/login';
  erreur:string;
  conseiller:Conseiller = new Conseiller();

  constructor(
    private http: HttpClient,
    public router: Router
  ){}

  authentification() {
    this.getEmploye(this.conseiller).subscribe(conseiller => {
      if (conseiller == null) {
        this.erreur = "Login/password incorrect.";
        console.log(this.erreur);
      } else {
        this.erreur = null;
        console.log("Le conseiller connecté est " + conseiller.prenom + " " + conseiller.nom);
        this.conseiller = conseiller;
        this.router.navigate(['clients']);
      }
    });
  }

  getEmploye(conseiller:Conseiller): Observable<Conseiller> {
    return this.http.post<Conseiller>(this.loginUrl, conseiller, httpOptions).pipe(
      catchError(this.handleError<Conseiller>('authentification'))
    );
  }

  seDeconnecter(){
    this.conseiller = null;
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
