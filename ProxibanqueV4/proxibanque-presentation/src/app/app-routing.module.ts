import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { ClientsComponent }   from './clients/clients.component';
import { ClientDetailComponent }   from './client-detail/client-detail.component';
import { ClientCreationComponent } from './client-creation/client-creation.component';
import { LoginComponent } from './login/login.component';

import { LogoutComponent } from './logout/logout.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { VirementComponent } from './virement/virement.component';
import { VirementListeComponent } from './virement-liste/virement-liste.component';
import { CompteListeComponent } from './compte-liste/compte-liste.component';
import { CompteCreationComponent } from './compte-creation/compte-creation.component';
import { AuditComponent } from './audit/audit.component';
import { ConseillersComponent } from './conseillers/conseillers.component';
import { EditClientComponent } from './edit-client/edit-client.component';

const routes: Routes = [
  //route par defaut au démarrage de l'appli
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'clients', component: ClientsComponent },
  { path: 'client/creer', component: ClientCreationComponent },
  { path: 'edit/:id', component: EditClientComponent },

  //Route paramétrée par :id
  //Le signe deux-points (:) dans le chemin indique que: id est un espace réservé pour un identifiant de client spécifique.
  { path: 'detail/:id', component: ClientDetailComponent},
  { path: 'virement', component: VirementComponent },
  { path: 'virement/liste', component: VirementListeComponent },
  { path: 'compte/liste', component: CompteListeComponent },
  { path: 'compte/creer', component: CompteCreationComponent },
  { path: 'audit', component: AuditComponent },
  { path: 'conseillers', component: ConseillersComponent },
  //Erreur 404
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
