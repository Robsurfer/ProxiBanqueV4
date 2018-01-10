import { Component, OnInit } from '@angular/core';
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

  //Liste des clients
    virements: Virement[];

    //Attend que l'Observable émette le tableau des clients
    //Subscribe passe ensuite le tableau émis au callback, qui définit la propriété clients du composant.
    //Cette approche asynchrone fonctionne lorsque ClientService demande des clients au serveur.
    getVirements(): void {
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

  }

}
