import { Component, OnInit, Input} from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Compte } from '../compte';
import { CompteService } from '../compte.service';
import { VirementService } from '../virement.service';
import { Employe } from '../employe';
import { VirementFormulaire } from '../virement-formulaire';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {
  employeLogin : string;  
  comptesConseiller : Compte[];
  comptesAgence : Compte[];

  compteEmetteur : Compte;
  compteCible : Compte;

  @Input() numCompteEmetteur : number;
  @Input() numCompteCible : number;

  @Input() succesCreation : string;
  @Input() erreurCreation : string;
  @Input() warningCreation : string;

  @Input() montant : number;
  @Input() libelle : string;

  virement : VirementFormulaire;


  getComptesAgence(): void {
    this.compteService.getComptesAgence()
        .subscribe(comptesAgence => this.comptesAgence = comptesAgence);
  }

  getComptesConseiller(): void {
    this.compteService.getComptes()
        .subscribe(comptesConseiller => this.comptesConseiller = comptesConseiller);
  }

  effectuerVirement() : void
  {
    if(!this.montant)
    {
      this.warningCreation ="Veuillez saisir un montant pour la transaction";
    }
    else
    {
      this.virement = new VirementFormulaire();
      this.virement.numCompteEmetteur = this.numCompteEmetteur;
      this.virement.numCompteCible = this.numCompteCible;
      this.virement.montant = this.montant;
      this.virement.libelle = this.libelle;
      
      this.virementService.addVirement(this.virement).subscribe(message => {

        if(message.includes('succès'))
        {
          this.succesCreation = message;
        }
        else
        {
          this.erreurCreation = message;
        }        
      });
    }
  }

  constructor(
    private compteService : CompteService, 
    private loginService : LoginService,
    private virementService : VirementService,    
    private router : Router){}

  ngOnInit() {

    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }
    this.erreurCreation = null;
    this.succesCreation = null;
    this.warningCreation = null;

    this.employeLogin = this.loginService.getLoginEmployeSession();
    this.getComptesConseiller();
    this.getComptesAgence();
  }

  reInitMessage() {
    this.erreurCreation = null;
    this.succesCreation = null;
    this.warningCreation = null;
  }
}
