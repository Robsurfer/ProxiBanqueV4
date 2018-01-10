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
    this.loginService.getNomEmployeSessionObs().subscribe(nom => this.employe.nom = nom);
    this.loginService.getPrenomEmployeSessionObs().subscribe(prenom => this.employe.prenom = prenom);  
  }

  deconnexion(){
    this.loginService.seDeconnecter();
  }
}
