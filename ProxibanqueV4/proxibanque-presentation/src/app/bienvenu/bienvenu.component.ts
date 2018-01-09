import { Component, OnInit } from '@angular/core';
import { Conseiller } from '../conseiller';
import { Client } from '../client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-bienvenu',
  templateUrl: './bienvenu.component.html',
  styleUrls: ['./bienvenu.component.css']
})
export class BienvenuComponent implements OnInit {
  //Liste des clients
  clients: Client[];

  //Conseiller stocké en dur car pas encore de login
  conseiller : Conseiller = {
    prenom : "Bugs",
    nom : "Bunny",
    login : "Lapin",
    password : "Lapin"
  };
  
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
    console.log(this.clients);
  }

}
