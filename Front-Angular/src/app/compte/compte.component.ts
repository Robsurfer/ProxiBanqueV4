import { Component, OnInit } from '@angular/core';

import { Compte } from '../compte';
import { CompteService } from '../compte.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {

  //Liste des Comptes
  comptes: Compte[];

 //Attend que l'Observable émette le tableau des clients
 //Subscribe passe ensuite le tableau émis au callback, qui définit la propriété clients du composant.
 //Cette approche asynchrone fonctionne lorsque ClientService demande des clients au serveur.
 getComptes(): void
 {
   this.compteService.getComptes()
       .subscribe(comptes => this.comptes = comptes);
 }

  constructor(private compteService : CompteService) { }

  ngOnInit(){
    this.getComptes(),
  }

}
