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

  //Injecte les services ActivatedRoute, HeroService et Location dans le constructeur, en enregistrant leurs valeurs dans des champs privés
  constructor(
    //Contient des informations sur l'itinéraire vers cette instance de HeroDetailComponent.
    //Ce composant s'intéresse au sac de paramètres de la route extrait de l'URL.
    //Le paramètre "id" est l'identifiant du héros à afficher.
    private route: ActivatedRoute,
    //Obtient des données de héros du serveur distant et ce composant l'utilisera pour obtenir le héros à afficher.
    private clientService: ClientService,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }
    this.getClient();
  }

  getClient(): void {
    //Route.snapshot est une image statique des informations d'itinéraire peu après la création du composant
    //paramMap est un dictionnaire de valeurs de paramètres de route extraites de l'URL
    //La clé "id" renvoie l'identifiant du héros à récupérer.
    //Les paramètres d'itinéraire sont toujours des chaînes.
    //L'opérateur JavaScript (+) convertit la chaîne en un nombre, ce que devrait être un identifiant de héros.
    const id = +this.route.snapshot.paramMap.get('id');
    this.clientService.getClient(id)
      .subscribe(client => this.client = client);
  }
}
