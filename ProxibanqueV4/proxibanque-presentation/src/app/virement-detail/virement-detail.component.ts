import { Component, OnInit, Input } from '@angular/core';
import { Location } from '@angular/common';
import { LoginService } from '../login.service';
import { CompteService } from '../compte.service';
import { VirementService } from '../virement.service';
import { Virement } from '../virement';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-virement-detail',
  templateUrl: './virement-detail.component.html',
  styleUrls: ['./virement-detail.component.css']
})
export class VirementDetailComponent implements OnInit {

  @Input() selectedCompte;
  numCompte: number;
  virementsDebit: Virement[];
  virementsCredit: Virement[];
  
  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private loginService : LoginService,
    private compteService: CompteService,
    private virementService: VirementService,
    private router: Router
  ){}

  goBack(): void {
    this.location.back();    
  }

  getVirement(numero : number) :void
  {
    this.virementService.getVirementsByCompteCible(numero)
      .subscribe(debit => this.virementsDebit = debit);
    this.virementService.getVirementsByCompteEmetteur(numero)
      .subscribe(credit => this.virementsCredit = credit);
  }

  ngOnInit() {
    this.numCompte = +this.route.snapshot.paramMap.get('numero');
    this.getVirement(this.numCompte)  ;    
  }

}
