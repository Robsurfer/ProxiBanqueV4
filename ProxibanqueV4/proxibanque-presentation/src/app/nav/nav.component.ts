import { Component, OnInit, Input } from '@angular/core';
import { Employe } from '../employe';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: [ './nav.component.css' ]
})

export class NavComponent implements OnInit {
  
  //Le titre provenant de app.component
  @Input() title: string;
  employe: Employe = {
    login: '',
    password: '',
    nom: '',
    prenom: '',
    role: ''
  };
  
  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.employe.nom = this.loginService.getNomEmployeSession();
    this.employe.prenom = this.loginService.getPrenomEmployeSession();
  }
}
