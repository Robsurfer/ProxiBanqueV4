import { Component, OnInit } from '@angular/core';

import { ListeVirementService } from '../listevirement.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Virement } from '../virement';
import { VirementService } from '../virement.service';

@Component({
  selector: 'app-virement-liste',
  templateUrl: './virement-liste.component.html',
  styleUrls: ['./virement-liste.component.css']
})
export class VirementListeComponent implements OnInit {

  //Liste des virements
    virements: Virement[];

    //Attend que l'Observable émette le tableau des virements
    //Subscribe passe ensuite le tableau émis au callback, qui définit la propriété virements du composant.
    //Cette approche asynchrone fonctionne lorsque ViçrementService demande des virements au serveur.
    getVirementsConseiller(): void {
      this.virementService.getVirementsConseiller()
          .subscribe(virements => this.virements = virements);
    }

  constructor(
    private virementService: VirementService,
    private loginService : LoginService, 
    private router : Router) { }


  ngOnInit() {

    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

    this.getVirementsConseiller();
  }

}
