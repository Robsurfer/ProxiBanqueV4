import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Employe } from '../conseiller';

@Component({
  selector: 'app-client-creation',
  templateUrl: './client-creation.component.html',
  styleUrls: ['./client-creation.component.css']
})
export class ClientCreationComponent implements OnInit {
  employeLogin : string;  
  constructor(private loginService : LoginService) { }

  ngOnInit() {
    this.employeLogin = this.loginService.getLoginEmployeSession();
    
  }

}
