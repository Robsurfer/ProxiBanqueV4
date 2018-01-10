import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';
import { LoginService } from '../login.service';
import { CompteService } from '../compte.service';
import { Router } from '@angular/router';
import { Compte } from '../compte';

@Component({
  selector: 'app-compte-liste',
  templateUrl: './compte-liste.component.html',
  styleUrls: ['./compte-liste.component.css']
})
export class CompteListeComponent implements OnInit {

//Liste des clients
clients: Client[];
comptes: Compte[];

//client selectionné
selectedClient: Client;

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
  private compteService: CompteService,
  private router : Router){}

ngOnInit() {

  if (!this.loginService.getLoginEmployeSession()) {
    this.router.navigate(['login']);
  }

  sessionStorage.setItem('annulModif',null);
  sessionStorage.setItem('messageModif',null);

  this.getClients();
}

/*
onClick(client: Client): void
{
  this.compteService.getCompte(client.id)
      .subscribe(comptes => this.comptes = comptes);
}
*/


}
