
import { Component, OnInit } from '@angular/core';

import { Client } from '../client';
import { ClientService } from '../client.service';

import { Compte } from '../compte';
import { CompteService } from '../compte.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {
  //Liste des clients
  clients: Client[];

  selectedClient : Client;

  onSelect(client: Client):void
  {
    this.selectedClient = client;
  }

  //Liste comptes
  comptes: Compte[];

  //Attend que l'Observable émette le tableau des clients
  //Subscribe passe ensuite le tableau émis au callback, qui définit la propriété clients du composant.
  //Cette approche asynchrone fonctionne lorsque ClientService demande des clients au serveur.
  getClients(): void {
    this.clientService.getClients()
        .subscribe(clients => this.clients = clients);
  }

  //


  constructor(
    private clientService : ClientService,
    private compteService : CompteService
  ){}

  ngOnInit() {
    this.getClients();
  }

}
