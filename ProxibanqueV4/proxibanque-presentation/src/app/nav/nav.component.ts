import { Component, OnInit, Input } from '@angular/core';
import { Conseiller } from '../conseiller';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: [ './nav.component.css' ]
})

export class NavComponent implements OnInit {
  
  //Le titre provenant de app.component
  @Input() title: string;
  @Input() conseiller : Conseiller;
  
  constructor() { }

  ngOnInit() {
    
  }
}
