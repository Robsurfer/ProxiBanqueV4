import { Injectable } from '@angular/core';
import { Employe } from './employe';
import { Observable } from 'rxjs/Rx';
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

  constructor(
    private http: HttpClient,
    public router: Router
  ){}

  authentification(login, password) {
    //console.log("Début de l'authentification");
    const data = {login: login, password: password}
    //console.log("data envoyée : " + data.login + " " + data.password);
    this.getEmployeFromWS(data).subscribe(employe => {
      if (employe == null) {
        this.erreur = "Login/password incorrect.";
        //console.log(this.erreur);
      } else {
        this.erreur = null;
        //console.log("L'utilisateur connecté est " + employe.prenom + " " + employe.nom);
        //console.log("Il s'agit d'un " + employe.role);
        sessionStorage.setItem('login', JSON.stringify(employe.login));
        sessionStorage.setItem('prenom', JSON.stringify(employe.prenom));
        sessionStorage.setItem('nom', JSON.stringify(employe.nom));
        sessionStorage.setItem('role', JSON.stringify(employe.role));
        //console.log("Le conseiller en session est :");
        //console.log(localStorage.getItem('employe'));
        this.router.navigate(['clients']);
      }
    });
  }

  getEmployeFromWS(data): Observable<Employe> {
    return this.http.post<Employe>(this.loginUrl, data, httpOptions);
  }

  seDeconnecter(){
    sessionStorage.clear();
    this.router.navigate(['logout']);
  }

  getLoginEmployeSession(): string {
    return JSON.parse(sessionStorage.getItem('login'));
  }

  getNomEmployeSession(): string {
    return JSON.parse(sessionStorage.getItem('nom'));
  }

  getPrenomEmployeSession(): string {
    return JSON.parse(sessionStorage.getItem('prenom'));
  }

  getRoleEmployeSession(): string {
    return JSON.parse(sessionStorage.getItem('role'));
  }

  getLoginEmployeSessionObs(): Observable<string> {
    return Observable.of(JSON.parse(sessionStorage.getItem('login')));
  }

  getNomEmployeSessionObs(): Observable<string> {
    return Observable.of(JSON.parse(sessionStorage.getItem('nom')));
  }

  getPrenomEmployeSessionObs(): Observable<string> {
    return Observable.of(JSON.parse(sessionStorage.getItem('prenom')));
  }

  getRoleEmployeSessionObs(): Observable<string> {
    return Observable.of(JSON.parse(sessionStorage.getItem('role')));
  }

}
