import { Component, OnInit, Input } from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';
import { LoginService } from '../login.service';
import { CompteService } from '../compte.service';
import { Router } from '@angular/router';
import { Compte } from '../compte';
import { Virement } from '../virement';

@Component({
  selector: 'app-compte-liste',
  templateUrl: './compte-liste.component.html',
  styleUrls: ['./compte-liste.component.css']
})
export class CompteListeComponent implements OnInit {

//Liste des clients
clients: Client[];
comptes: Compte;
selectedCompte: Compte;
virements: Virement;

//client selectionné
@Input() id: number;

//Attend que l'Observable émette le tableau des clients
//Subscribe passe ensuite le tableau émis au callback, qui définit la propriété clients du composant.
//Cette approche asynchrone fonctionne lorsque ClientService demande des clients au serveur.
getClients(): void {
  this.clientService.getClients()
      .subscribe(clients => this.clients = clients);
}
constructor(
  private clientService : ClientService, 
  private loginService : LoginService,
  private compteService: CompteService,
  private router : Router){}

ngOnInit() {

  if (!this.loginService.getLoginEmployeSession()) {
    this.router.navigate(['login']);
  }

  sessionStorage.setItem('annulModif',null);
  sessionStorage.setItem('messageModif',null);

  this.getClients();
}

onClick(): void
{
  this.selectedCompte = null;
  this.compteService.getCompte(this.id)
      .subscribe(comptes => this.comptes = comptes);
}

onSelect(compte: Compte): void {
  this.selectedCompte = compte;

}


}
