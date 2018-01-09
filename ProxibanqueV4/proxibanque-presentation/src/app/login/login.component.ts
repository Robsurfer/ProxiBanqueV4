import { Component, OnInit } from '@angular/core';
import { Employe } from '../employe';
import { HttpClient } from '@angular/common/http/src/client';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employe:Employe = new Employe();

  constructor(private loginService:LoginService) { }

  ngOnInit() {
    this.employe.login='';
    this.employe.password='';
    this.employe.nom = '';
    this.employe.prenom = '';
  }

  onSubmit(){  
    this.loginService.authentification(this.employe.login, this.employe.password);    
  }
}
