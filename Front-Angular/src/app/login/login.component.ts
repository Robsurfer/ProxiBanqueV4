import { Component, OnInit } from '@angular/core';
import { Conseiller } from '../conseiller';
import { HttpClient } from '@angular/common/http/src/client';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService:LoginService) { }

  ngOnInit() {
    this.loginService.conseiller.login='';
    this.loginService.conseiller.password='';
  }

  onSubmit(){  
    this.loginService.authentification();    
  }
}
