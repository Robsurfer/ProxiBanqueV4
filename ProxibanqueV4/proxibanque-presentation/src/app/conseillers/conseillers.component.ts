import { Component, OnInit } from '@angular/core';
import { Employe } from '../employe';
import { ConseillerService } from '../conseiller.service';


@Component({
  selector: 'app-conseillers',
  templateUrl: './conseillers.component.html',
  styleUrls: ['./conseillers.component.css']
})
export class ConseillersComponent implements OnInit {

 //Liste des conseillers
  conseillers: Employe[];

  //Attend que l'Observable émette le tableau des conseillers
  //Subscribe passe ensuite le tableau émis au callback, qui définit la propriété conseillers du composant.
  //Cette approche asynchrone fonctionne lorsque ConseillerService demande des conseillers au serveur.
  getConseillers(): void {
    this.conseillerService.getConseillers()
        .subscribe(conseillers => this.conseillers = conseillers);
  }
  constructor(private conseillerService : ConseillerService){}
  
  ngOnInit() {
    this.getConseillers();
  }
}
