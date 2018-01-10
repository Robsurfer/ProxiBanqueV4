import { Component, OnInit, Input} from '@angular/core';

import { Compte } from '../compte';
import { CompteService } from '../compte.service';
import { Client } from '../client';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-compte-detail',
  templateUrl: './compte-detail.component.html',
  styleUrls: ['./compte-detail.component.css']
})
export class CompteDetailComponent implements OnInit {

  comptes: Compte;
  @Input()  idClient : number;
 

  constructor(
    private compteService: CompteService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.getCompte();
  }

  getCompte():void
  {
    const id = +this.route.snapshot.paramMap.get('id');
    this.compteService.getCompte(id)
        .subscribe(comptes => this.comptes = comptes);
  }


}
