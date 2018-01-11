import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';
import { VirementService } from '../virement.service';
import { AuditService } from '../audit.service';
import { Virement } from '../virement';

@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styleUrls: ['./audit.component.css']
})
export class AuditComponent implements OnInit {

  chartOptions = {
    responsive: true,
    scales: {
      yAxes: [{
        ticks: {
          beginAtZero:true 
        }
      }]
    }
  };

  virements : Virement[];
  chartDataPie = [];
  chartDataHisto = [];
  donnees = [];
  donneesHisto = [];
  colors = [{backgroundColor: ["#3ebf9b", "#4d86dc", "#f3af37", "#e84351", "#434a54"]}];

  chartLabelsPie = ['Inférieurs à 500€', 'Entre 500€ et 1000€', 'Entre 1000€ et 5000€', 'Entre 5000€ et 20000€', 'Supérieurs à 20000€'];
  chartLabelsHisto = ['Septembre', 'Octobre', 'Novembre', 'Décembre', 'Janvier'];

  constructor(
    private loginService : LoginService,
    private virementService : VirementService, 
    private auditService : AuditService,
    private router : Router) { }

  ngOnInit() {
    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }
    this.getChartDataPie();
    this.getChartDataHisto();
  }

  getChartDataPie(){

    var nb1 = 0;
    var nb2 = 0;
    var nb3 = 0;
    var nb4 = 0;
    var nb5 = 0;
    
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
      console.log(this.donnees);
      this.chartDataPie = this.donnees;
  });
}

getChartDataHisto(){

  var nb1 = 0;
  var nb2 = 0;
  var nb3 = 0;
  var nb4 = 0;
  var nb5 = 0;
  
  //Get virements
  this.virementService.getVirementsAgence().subscribe(virements => {
    this.virements = virements;
    for (let virement of this.virements) {      
      var date = new Date(virement.dateVirement);
      console.log(date);
      console.log(date.getMonth());
      console.log(date.getFullYear());
      if (date.getMonth() == 8 && date.getFullYear() == 2017) {
        nb1 = nb1 + 1;
      } else if (date.getMonth() == 9 && date.getFullYear() == 2017) {
        nb2 = nb2 + 1;
      } else if (date.getMonth() == 10 && date.getFullYear() == 2017) {
        nb3 = nb3 + 1;
      } else if (date.getMonth() == 11 && date.getFullYear() == 2017) {
        nb4 = nb4 + 1;
      } else if (date.getMonth() == 0  && date.getFullYear() == 2018) {
        nb5 = nb5 + 1;
      }
    }
    
    this.donneesHisto[0] = nb1;
    this.donneesHisto[1] = nb2;
    this.donneesHisto[2] = nb3;
    this.donneesHisto[3] = nb4;
    this.donneesHisto[4] = nb5;

    console.log(this.donneesHisto);
    console.log(this.chartLabelsHisto);
    this.chartDataHisto = this.donneesHisto;
});
}


}
