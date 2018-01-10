import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../login.service';
import { Employe } from '../employe';
import { Router } from '@angular/router';
import { ClientService } from '../client.service';
import { Client } from '../client';
import { Location } from '@angular/common';

@Component({
  selector: 'app-client-creation',
  templateUrl: './client-creation.component.html',
  styleUrls: ['./client-creation.component.css']
})
export class ClientCreationComponent implements OnInit {

  employeLogin : string;  

  @Input() client: Client = {
    id:null,
    nom:'',
    prenom:'',
    ville:'',
    codePostal:'',
    adresse:'',
    telephone:'',
    mail:''
  };

  constructor(
    private loginService : LoginService, 
    private router : Router,
    private clientService : ClientService,
    private location: Location
  ) { }

  ngOnInit() {
    this.employeLogin = this.loginService.getLoginEmployeSession();
    
    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }
    sessionStorage.setItem('titrePage', "Création d'un nouveau client");

  }

  creationClient() {
    //console.log(this.client.id);
    this.clientService.addClient(this.client).subscribe(client => {
      //console.log(client);
      this.client = client;
      var message = "Le client " + this.client.prenom + " " + this.client.nom + " a bien été créé."
      sessionStorage.setItem('messageCreation',message);
      var idclient = this.client.id;
      //console.log(idclient);
      this.router.navigate(['detail/'+idclient]);
    });
  }

  goBack(): void {
    sessionStorage.setItem('annulCreation','La création d\'un nouveau client a été annulée.');
    this.location.back();
  }

}
