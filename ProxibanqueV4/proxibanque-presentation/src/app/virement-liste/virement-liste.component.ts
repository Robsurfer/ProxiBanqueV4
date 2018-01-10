import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

=======
import { Virement } from '../virement';
import { ListeVirementService } from '../listevirement.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
>>>>>>> listevirements
@Component({
  selector: 'app-virement-liste',
  templateUrl: './virement-liste.component.html',
  styleUrls: ['./virement-liste.component.css']
})
export class VirementListeComponent implements OnInit {

<<<<<<< HEAD
  constructor(private loginService : LoginService, private router : Router) { }
=======
  //Liste des virements
  virements: Virement[];
  constructor() { }
>>>>>>> listevirements

  ngOnInit() {

    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

  }

}
