import { Component, OnInit, Input } from '@angular/core';
import { Employe } from '../employe';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-nav-haut',
  templateUrl: './nav-haut.component.html',
  styleUrls: [ './nav-haut.component.css' ]
})

export class NavHautComponent implements OnInit {
  //Le titre provenant de app.component
  @Input() title: string;
  employe: Employe = {
    login: '',
    password: '',
    nom: '',
    prenom: '',
    role: ''
  };
  
  isCollabsed = false;

  toggleCollapsed(): void {
    this.isCollabsed = !this.isCollabsed;
  }

  constructor(private loginService: LoginService) { }

  ngOnInit() {
    this.employe.nom = this.loginService.getNomEmployeSession();
    this.employe.prenom = this.loginService.getPrenomEmployeSession();
  }
}
