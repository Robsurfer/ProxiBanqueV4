import { Component, OnInit } from '@angular/core';
import { Employe } from '../employe';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employe:Employe = new Employe();

  constructor(private loginService:LoginService, public router: Router) { }

  ngOnInit() {
    this.employe.login='';
    this.employe.password='';
    this.employe.nom = '';
    this.employe.prenom = '';


  }

  onSubmit(){  
    this.loginService.authentification(this.employe.login, this.employe.password);  

    //this.loginService.getLoginEmployeSessionObs().subscribe(login => this.employe.login = login);
    //this.loginService.getRoleEmployeSessionObs().subscribe(role => this.employe.role = role);

    /*
    if (this.loginService.getLoginEmployeSession() && (this.loginService.getRoleEmployeSession() =='conseiller')) {
      this.router.navigate(['clients']);
    }

    if (this.loginService.getLoginEmployeSession() && (this.loginService.getRoleEmployeSession() =='gerant')) {
      this.router.navigate(['conseillers']);
    } 
    */
  }
}
