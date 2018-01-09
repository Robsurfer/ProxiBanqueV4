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


  conseiller:Conseiller = new Conseiller();

  constructor(private loginService:LoginService) { }

  ngOnInit() {
    this.conseiller.login = '';
    this.conseiller.password = '';
  }

  onSubmit(){
    console.log("Début de l'authentification")
    this.loginService.authentification(this.conseiller)
        .subscribe(conseiller => this.conseiller = conseiller);        
  }
}
