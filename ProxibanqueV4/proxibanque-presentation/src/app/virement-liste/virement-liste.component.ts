import { Component, OnInit, Input } from '@angular/core';

import { Client } from '../client';
import { ClientService } from '../client.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { Virement } from '../virement';
import { VirementService } from '../virement.service';

@Component({
  selector: 'app-virement-liste',
  templateUrl: './virement-liste.component.html',
  styleUrls: ['./virement-liste.component.css']
})
export class VirementListeComponent implements OnInit {

  //Liste des clients
    clients: Client[];
  //Liste des virements
    virements: Virement[];
    
    //client selectionné
    @Input() id: number;
    
    getClients(): void {
      this.clientService.getClients()
          .subscribe(clients => this.clients = clients);
    }
   
    onClick(): void
    {
      if(this.id)
      {
        this.virementService.getVirementsByClient(this.id)
            .subscribe(virements => this.virements = virements);
      }
    }

  constructor(
    private clientService : ClientService,
    private virementService: VirementService,
    private loginService : LoginService, 
    private router : Router) { }


  ngOnInit() {

    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

    this.getClients();
    //this.getVirementsConseiller();
  }

}
