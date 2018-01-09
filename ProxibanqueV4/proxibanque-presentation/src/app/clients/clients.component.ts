import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';

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
  constructor(private clientService : ClientService){}
  
  ngOnInit() {
    this.getClients();
  }

}
