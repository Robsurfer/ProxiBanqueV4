import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-nav-gauche',
  templateUrl: './nav-gauche.component.html',
  styleUrls: [ './nav-gauche.component.css' ]
})

export class NavGaucheComponent implements OnInit {
  
  roleEmploye : string;
  constructor(private loginService : LoginService) { }

  ngOnInit() {
    //console.log(this.loginService.getRoleEmployeSession());
    this.roleEmploye = this.loginService.getRoleEmployeSession();
    //console.log(this.roleEmploye);
  }
}
