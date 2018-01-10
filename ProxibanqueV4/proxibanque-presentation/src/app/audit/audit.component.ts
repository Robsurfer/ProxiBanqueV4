import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { ListeVirementService } from '../listevirement.service';
import { AuditService } from '../audit.service';

@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styleUrls: ['./audit.component.css']
})
export class AuditComponent implements OnInit {

  constructor(
    private loginService : LoginService,
    private virementService : ListeVirementService, 
    private auditService : AuditService,
    private router : Router) { }

  ngOnInit() {

    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

  }

  getVirementsTries() {
    this.auditService.getVirements();
    console.log(this.auditService.getVirements());
  }

}
