import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})

export class DashboardComponent implements OnInit {
  //Est un service d'Angular pour interagir avec le navigateur. A utiliser pour revenir à la vue qui a navigué ici.
  private location: Location
  
  constructor() { }

  ngOnInit() {
    
  }
}
