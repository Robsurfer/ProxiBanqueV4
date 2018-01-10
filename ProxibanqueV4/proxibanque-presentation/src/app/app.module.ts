import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; //Pour NgModel nécessaire au 2-way data binding
// Pour la connexion Http
import { HttpClientModule } from '@angular/common/http';
// Pour les dropdown menu
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavGaucheComponent } from './nav-gauche/nav-gauche.component';
import { NavHautComponent } from './nav-haut/nav-haut.component';
import { AppRoutingModule } from './app-routing.module';
import { ClientsComponent } from './clients/clients.component';
import { ClientDetailComponent } from './client-detail/client-detail.component';
import { ClientService } from './client.service';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login.service';
import { ConseillerService } from './conseiller.service';
import { VirementService } from './virement.service';

import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { VirementComponent } from './virement/virement.component';
import { ClientCreationComponent } from './client-creation/client-creation.component';
import { VirementListeComponent } from './virement-liste/virement-liste.component';
import { CompteDetailComponent } from './compte-detail/compte-detail.component';
import { CompteListeComponent } from './compte-liste/compte-liste.component';
import { CompteCreationComponent } from './compte-creation/compte-creation.component';
import { LogoutComponent } from './logout/logout.component';
import { EtatRequeteComponent } from './etat-requete/etat-requete.component';
import { AuditComponent } from './audit/audit.component';
import { ConseillersComponent } from './conseillers/conseillers.component';

import { EditClientComponent } from './edit-client/edit-client.component';


@NgModule({
  //Les composants
  //Chaque composant doit être déclaré dans un et un seul NgModule
  declarations: [
    AppComponent,
    DashboardComponent,
    NavGaucheComponent,
    NavHautComponent,
    ClientsComponent,
    ClientDetailComponent,

    ClientCreationComponent,
    LoginComponent,
    PageNotFoundComponent,
    VirementComponent,
    VirementListeComponent,
    CompteDetailComponent,
    CompteListeComponent,
    CompteCreationComponent,
    LogoutComponent,
    EtatRequeteComponent,
    AuditComponent,
    ConseillersComponent,
    EtatRequeteComponent,
    LoginComponent,
	  EditClientComponent
],
  //le tableau des importations de métadonnées de @NgModule
  //Contient une liste de modules externes dont l'application a besoin
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule.forRoot()
  ],
  providers: [
    ClientService,
    LoginService,
    ConseillerService,
    VirementService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
