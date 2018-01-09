import { Component, OnInit, Input} from '@angular/core';

import { Compte } from '../compte';
import { CompteDetailService } from '../compte-detail.service';

@Component({
  selector: 'app-compte-detail',
  templateUrl: './compte-detail.component.html',
  styleUrls: ['./compte-detail.component.css']
})
export class CompteDetailComponent implements OnInit {

  comptes: Compte[];
  @Input()  idClient : number;

  constructor(private compteDetailService: CompteDetailService) { }

  ngOnInit() {
    this.getComptes();
  }

  getComptes():void 
  {
    this.compteDetailService.getComptes(this.idClient)
        .subscribe(comptes => this.comptes = comptes);
  }

}
