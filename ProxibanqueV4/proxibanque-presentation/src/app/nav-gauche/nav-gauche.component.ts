import { Component, OnInit, Input } from '@angular/core';
import { LoginService } from '../login.service';


@Component({
  selector: 'app-nav-gauche',
  templateUrl: './nav-gauche.component.html',
  styleUrls: [ './nav-gauche.component.css' ]
})

export class NavGaucheComponent implements OnInit {
  
  @Input() isCollapsed : boolean;

  roleEmploye : string;
  constructor(
    private loginService : LoginService
  ) { }

  ngOnInit() {
    this.roleEmploye = this.loginService.getRoleEmployeSession();
  }
}
