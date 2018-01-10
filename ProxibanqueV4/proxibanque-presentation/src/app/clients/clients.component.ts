import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {
  //Liste des clients
  clients: Client[];

  //Attend que l'Observable émette le tableau des clients
  //Subscribe passe ensuite le tableau émis au callback, qui définit la propriété clients du composant.
  //Cette approche asynchrone fonctionne lorsque ClientService demande des clients au serveur.
  getClients(): void {
    this.clientService.getClients()
        .subscribe(clients => this.clients = clients);
  }
  constructor(
    private clientService : ClientService, 
    private loginService : LoginService,
    private router : Router){}
  
  ngOnInit() {

    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

    //Redirection vers la page de login si gerant en session
    if (this.loginService.getRoleEmployeSession() == 'gerant') {
      this.router.navigate(['conseillers']);
    }

    sessionStorage.setItem('annulModif',null);
    sessionStorage.setItem('messageModif',null);

    this.getClients();

    sessionStorage.setItem('titrePage', 'Liste de vos clients');
  }

}
