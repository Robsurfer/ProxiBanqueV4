import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; //Pour NgModel nécessaire au 2-way data binding
// Pour la connexion Http
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavComponent } from './nav/nav.component';
import { AppRoutingModule } from './app-routing.module';
import { BienvenuComponent } from './bienvenu/bienvenu.component';
import { ClientsComponent } from './clients/clients.component';
import { ClientDetailComponent } from './client-detail/client-detail.component';
import { ClientService } from './client.service';
import { CompteService } from './compte.service';
import { CompteComponent } from './compte/compte.component';

@NgModule({
  //Les composants
  //Chaque composant doit être déclaré dans un et un seul NgModule
  declarations: [
    AppComponent,
    DashboardComponent,
    NavComponent,
    BienvenuComponent,
    ClientsComponent,
    ClientDetailCompo,
    CompteComponentnent
  ],
  //le tableau des importations de métadonnées de @NgModule
  //Contient une liste de modules externes dont l'application a besoin
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ClientS, CompteServiceervice],
  bootstrap: [AppComponent]
})
export class AppModule { }
