import { Component } from '@angular/core';
import { Employe } from './employe';
import { LoginService } from './login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Proxibanque';
   
  constructor(private loginService:LoginService){ }

}
