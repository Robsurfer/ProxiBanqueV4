import { Component, OnInit } from '@angular/core';
import { Virement } from '../virement';
import { ListeVirementService } from '../listevirement.service';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-virement-liste',
  templateUrl: './virement-liste.component.html',
  styleUrls: ['./virement-liste.component.css']
})
export class VirementListeComponent implements OnInit {

  //Liste des virements
  virements: Virement[];
  constructor() { }

  ngOnInit() {
  }

}
