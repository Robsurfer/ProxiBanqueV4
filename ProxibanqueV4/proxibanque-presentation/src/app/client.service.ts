import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { Injectable } from '@angular/core';

import { Client } from './client';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';
import { LoginService } from './login.service';
//Pour l'update
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ClientService {

    // URL vers le web service
    private clientsUrl = 'http://localhost:8082/conseiller/'+ this.loginService.getLoginEmployeSession() + '/clients'; 

    constructor(
        private http: HttpClient,
        private loginService: LoginService
    ){}

  /** GET clients from the server */
  getClients (): Observable<Client[]> {
    console.log(this.http.get<Client[]>(this.clientsUrl));
    console.log(this.loginService.getLoginEmployeSession());
    return this.http.get<Client[]>(this.clientsUrl)
      .pipe(
        catchError(this.handleError('getClients', []))
      );
  }

  /** GET client by id. Will 404 if id not found */
  /*
    il construit une URL de requête avec l'identifiant du héros désiré.
    le serveur devrait répondre avec un seul héros plutôt qu'un ensemble de héros.
    par conséquent, getClient renvoie un <Client> observable ("un observable des objets Client") plutôt qu'un observable des tableaux de héros.
    */
  getClient(id: number): Observable<Client> {
    const url = `${this.clientsUrl}/${id}`;
    return this.http.get<Client>(url).pipe(
      catchError(this.handleError<Client>(`getClient id=${id}`))
    );
  }

  /*
    La structure globale de la méthode updateClient () est similaire à celle de getClientes (),
    mais elle utilise http.put () pour conserver le héros modifié sur le serveur.
    La méthode HttpClient.put () prend trois paramètres
      - l'URL
      - les données à mettre à jour (le héros modifié dans ce cas)
      - options
    L'URL est inchangée. L'API web des héros sait quel héros mettre à jour en regardant l'identifiant du héros.
    L'API web des héros attend un en-tête spécial dans les requêtes d'enregistrement HTTP.
    Cet en-tête est dans la constante httpOption définie dans ClientService.
  */
  /** PUT: update the client on the server */
  updateClient (client: Client): Observable<any> {
    return this.http.put(this.clientsUrl, client, httpOptions).pipe(
      catchError(this.handleError<any>('updateClient'))
    );
  }

  /*
  ClientService.addClient () diffère de updateClient de deux façons.
    - il appelle HttpClient.post () au lieu de put ().
    - il s'attend à ce que le serveur génère un identifiant pour le nouveau héros, qu'il renvoie dans l'Observable <Héros> à l'appelant.
  */
  /** POST: add a new client to the server */
  addClient (client: Client): Observable<Client> {
    return this.http.post<Client>(this.clientsUrl, client, httpOptions).pipe(
      catchError(this.handleError<Client>('addClient'))
    );
  }

  /*
  La méthode retourne immédiatement avec un tableau vide s'il n'y a pas de terme de recherche. Le reste ressemble beaucoup à getClientes ().
  La seule différence significative est l'URL, qui inclut une chaîne de requête avec le terme de recherche.
  */
  /* GET clientes whose name contains search term */
  searchClients(term: string): Observable<Client[]> {
    if (!term.trim()) {
      // if not search term, return empty client array.
      return of([]);
    }
    return this.http.get<Client[]>(`api/clients/?name=${term}`).pipe(
      catchError(this.handleError<Client[]>('searchClients', []))
    );
  }
  /** DELETE: delete the client from the server */
  deleteClient (client: Client | number): Observable<Client> {
    const id = typeof client === 'number' ? client : client.id;
    const url = `${this.clientsUrl}/${id}`;

    return this.http.delete<Client>(url, httpOptions).pipe(
      catchError(this.handleError<Client>('deleteClient'))
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
