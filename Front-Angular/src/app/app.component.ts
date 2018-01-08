import { Component } from '@angular/core';
import { Conseiller } from './conseiller';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Proxibanque';
   
  //Conseiller stocké en dur car pas encore de login
  conseiller : Conseiller = {
    prenom : "Bugs",
    nom : "Bunny",
    login : "Lapin",
    password : "Lapin"
  };

}
