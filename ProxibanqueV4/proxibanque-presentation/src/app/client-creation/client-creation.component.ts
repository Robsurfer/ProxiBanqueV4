import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Employe } from '../conseiller';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-creation',
  templateUrl: './client-creation.component.html',
  styleUrls: ['./client-creation.component.css']
})
export class ClientCreationComponent implements OnInit {
  employeLogin : string;  
  constructor(private loginService : LoginService, private router : Router) { }

  ngOnInit() {
    this.employeLogin = this.loginService.getLoginEmployeSession();
    
    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

  }

  creationClient() {

  }

}
