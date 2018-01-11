import { Component, OnInit, Input } from '@angular/core';
import { Employe } from '../employe';
import { LoginService } from '../login.service';
import { Client } from '../client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-nav-haut',
  templateUrl: './nav-haut.component.html',
  styleUrls: [ './nav-haut.component.css' ]
})

export class NavHautComponent implements OnInit {
  //Le titre provenant de app.component
  @Input() isCollapsed : boolean;

  @Input() title: string;
  employe: Employe = {
    login: '',
    password: '',
    nom: '',
    prenom: '',
    role: ''
  };
  
  //Liste des clients
  clients: Client[];

  getClients(): void {
    this.clientService.getClients()
        .subscribe(clients => this.clients = clients);
  }

  constructor(
    private loginService: LoginService,
    private clientService : ClientService
  ) { }

  ngOnInit() {
    this.loginService.getNomEmployeSessionObs().subscribe(nom => this.employe.nom = nom);
    this.loginService.getPrenomEmployeSessionObs().subscribe(prenom => this.employe.prenom = prenom);  
    this.getClients();
    this.isCollapsed = true;
  }

  deconnexion(){
    this.loginService.seDeconnecter();    
  }
}
