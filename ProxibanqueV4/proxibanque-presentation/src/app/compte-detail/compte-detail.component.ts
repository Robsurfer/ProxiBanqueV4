import { Component, OnInit, Input} from '@angular/core';

import { Compte } from '../compte';
import { CompteService } from '../compte.service';


@Component({
  selector: 'app-compte-detail',
  templateUrl: './compte-detail.component.html',
  styleUrls: ['./compte-detail.component.css']
})
export class CompteDetailComponent implements OnInit {

  comptes: Compte;
  @Input()  idClient : number;
  @Input() client: Client;




  constructor(private compteService: CompteService) { }

  ngOnInit() {
    this.getCompte();
    this.getCompteBis();
  }

  getCompte():void
  {
    this.compteService.getCompte(this.idClient)
        .subscribe(comptes => this.comptes = comptes);
  }

  getCompteBis():void
  {
    this.compteService.getCompte(this.client.id)
        .subscribe(comptes => this.comptes = comptes);
  }


}
