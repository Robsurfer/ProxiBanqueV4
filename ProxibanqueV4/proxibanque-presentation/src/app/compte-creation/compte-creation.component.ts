import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-compte-creation',
  templateUrl: './compte-creation.component.html',
  styleUrls: ['./compte-creation.component.css']
})
export class CompteCreationComponent implements OnInit {

  constructor(private loginService : LoginService, private router: Router) { }

  ngOnInit() {

    //Redirection vers la page de login si aucun conseiller en session
    if (!this.loginService.getLoginEmployeSession()) {
      this.router.navigate(['login']);
    }

  }

}
