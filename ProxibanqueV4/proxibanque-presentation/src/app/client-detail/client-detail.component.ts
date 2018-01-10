import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Client } from '../client';
import { ClientService }  from '../client.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-detail',
  templateUrl: './client-detail.component.html',
  styleUrls: ['./client-detail.component.css']
})
export class ClientDetailComponent implements OnInit {

  //Propriété client provenant de ClientsComponent
  @Input() client: Client;
  message: String = null;
  annulModif: String = null;

  //Injecte les services ActivatedRoute, HeroService et Location dans le constructeur, en enregistrant leurs valeurs dans des champs privés
  constructor(
    private route: ActivatedRoute,
    private clientService: ClientService,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

    this.message = null;
    this.annulModif = null;
    const valid = (sessionStorage.getItem('messageModif'));
    const annul = (sessionStorage.getItem('annulModif'));

    //initialisation du client
    this.getClient();

    //initialisation du message de succès de la modification si nécessaire
    if (valid != "null") {
      this.message = "La modification a bien été prise en compte";
      sessionStorage.setItem('messageModif', null);
    } else if (annul != "null") {
      this.annulModif = "La modification a bien été annulée.";
      sessionStorage.setItem('annulModif', null);
    }

  }

  getClient(): void {
    //Route.snapshot est une image statique des informations d'itinéraire peu après la création du composant
    //paramMap est un dictionnaire de valeurs de paramètres de route extraites de l'URL
    //La clé "id" renvoie l'identifiant du héros à récupérer.
    //Les paramètres d'itinéraire sont toujours des chaînes.
    //L'opérateur JavaScript (+) convertit la chaîne en un nombre, ce que devrait être un identifiant de héros.
    const id = +this.route.snapshot.paramMap.get('id');
    this.clientService.getClient(id)
      .subscribe(client => {
        this.client = client;
        var titre = "Détails du client " + this.client.prenom + " " + this.client.nom;
        sessionStorage.setItem('titrePage', titre);
      });
  }
}
