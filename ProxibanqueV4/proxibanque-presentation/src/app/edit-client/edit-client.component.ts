import { Component, OnInit, Input} from '@angular/core';
import { Client } from '../client';
import { ClientService } from '../client.service';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {

  @Input() client: Client;

  constructor(
    private route: ActivatedRoute,
    private clientService: ClientService,
    private location: Location
    ) { }

  ngOnInit() {
    this.getClient();
  }

  getClient(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.clientService.getClient(id)
      .subscribe(client => this.client = client);
  }
 
  goBack(): void {
    sessionStorage.setItem('annulModif','La modification a été annulée.');
    this.location.back();
  }

  editClient() {
    this.clientService.updateClient(this.client).subscribe(client => this.client = client);
    sessionStorage.setItem('messageModif','La modification a bien été prise en compte.');

    this.location.back();
  }

}
