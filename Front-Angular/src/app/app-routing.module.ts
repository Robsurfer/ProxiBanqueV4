import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent }   from './dashboard/dashboard.component';
import { BienvenuComponent }   from './bienvenu/bienvenu.component';
import { ClientsComponent }   from './clients/clients.component';
import { ClientDetailComponent }   from './client-detail/client-detail.component';

const routes: Routes = [
  //route par defaut au démarrage de l'appli
  { path: '', redirectTo: '/bienvenu', pathMatch: 'full' },
  { path: 'bienvenu', component: BienvenuComponent },
  { path: 'clients', component: ClientsComponent },

  //Route paramétrée par :id
  //Le signe deux-points (:) dans le chemin indique que: id est un espace réservé pour un identifiant de client spécifique.
  { path: 'detail/:id', component: ClientDetailComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}