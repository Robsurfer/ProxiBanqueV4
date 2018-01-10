import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Compte } from '../compte';
import { CompteService } from '../compte.service';
import { Employe } from '../employe';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {
  employeLogin : string;  
  comptesConseiller : Compte[];
  comptesAgence : Compte[];

  getComptesAgence(): void {
    this.compteService.getComptesAgence()
        .subscribe(comptesAgence => this.comptesAgence = comptesAgence);
  }

  getComptesConseiller(): void {
    this.compteService.getComptes()
        .subscribe(comptesConseiller => this.comptesConseiller = comptesConseiller);
  }

  constructor(
    private compteService : CompteService, 
    private loginService : LoginService,
    private router : Router){}

  ngOnInit() {

    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

    sessionStorage.setItem('annulModif',null);
    sessionStorage.setItem('messageModif',null);

    this.employeLogin = this.loginService.getLoginEmployeSession();
    this.getComptesConseiller();
    this.getComptesAgence();
  }

}
