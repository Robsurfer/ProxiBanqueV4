import { Injectable } from '@angular/core';
import { VirementService } from './virement.service';
import { Virement } from './virement';
import { forEach } from '@angular/router/src/utils/collection';

import { Observable } from 'rxjs/Rx';

@Injectable()
export class AuditService {

  virements: Virement[];
  chartData;
  donnees = [];
  chartLabels = ['Inférieurs à 500€', 'Entre 500€ et 1000€', 'Entre 1000€ et 5000€', 'Entre 5000€ et 20000€', 'Supérieurs à 20000€'];

  constructor(private virementService: VirementService) { }   

  /*
  triVirementsMontant(): Observable<any>{
    var nb1 = 0;
    var nb2 = 0;
    var nb3 = 0;
    var nb4 = 0;
    var nb5 = 0;
    this.chartData[0] = this.chartLabels;
    console.log("toto" + this.chartData);
    //Get virements
    this.virementService.getVirementsAgence().subscribe(virements => {
      this.virements = virements;
      for (let virement of this.virements) {
        if (virement.montant < 500) {
          nb1 = nb1 + 1;
        } else if (virement.montant >= 500 && virement.montant < 1000) {
          nb2 = nb2 + 1;
        } else if (virement.montant >= 1000 && virement.montant < 5000) {
          nb3 = nb3 + 1;
        } else if (virement.montant >= 5000 && virement.montant < 20000) {
          nb4 = nb4 + 1;
        } else if (virement.montant > 20000) {
          nb5 = nb5 + 1;
        }
      }
      this.donnees[0] = nb1;
      this.donnees[1] = nb2;
      this.donnees[2] = nb3;
      this.donnees[3] = nb4;
      this.donnees[4] = nb5;

      this.chartData = [{data: this.donnees, label: 'Virements sur les 3 derniers mois'}];
      var retour = Observable.of(this.chartData);
  });
      return retour;
  }
*/
}
