import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; //Pour NgModel nécessaire au 2-way data binding
// Pour la connexion Http
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavComponent } from './nav/nav.component';
import { AppRoutingModule } from './app-routing.module';
import { ClientsComponent } from './clients/clients.component';
import { ClientDetailComponent } from './client-detail/client-detail.component';
import { ClientService } from './client.service';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login.service';

@NgModule({
  //Les composants
  //Chaque composant doit être déclaré dans un et un seul NgModule
  declarations: [
    AppComponent,
    DashboardComponent,
    NavComponent,
    ClientsComponent,
    ClientDetailComponent,
	LoginComponent
  ],
  //le tableau des importations de métadonnées de @NgModule
  //Contient une liste de modules externes dont l'application a besoin
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    ClientService,
    LoginService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
