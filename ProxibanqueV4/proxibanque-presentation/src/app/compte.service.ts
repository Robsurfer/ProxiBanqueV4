import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Compte } from './compte';
import { LoginService } from './login.service';

@Injectable()
export class CompteService {
  
  private compteDetailUrl = 'http://localhost:8082/conseiller/' + this.loginService.conseiller.login + '/clients/comptes';

  constructor(
    private http: HttpClient,
    private loginService: LoginService
  ) { }

  getComptes(id: number): Observable<Compte[]>{
    const url = `${this.compteDetailUrl}/${id}`;
    return this.http.get<Compte[]>(this.compteDetailUrl)
      
  }

}
