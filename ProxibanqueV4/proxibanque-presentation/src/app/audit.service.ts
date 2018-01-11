import { Injectable } from '@angular/core';
import { VirementService } from './virement.service';
import { Virement } from './virement';
import { WebserviceService } from './webservice.service';

@Injectable()
export class AuditService {
  
  virements: Virement[];

  constructor(
    private virementService: VirementService,
    private webService: WebserviceService
  ) { }

  getVirements(){
    this.virementService.getVirementsAgence().subscribe(virements => this.virements = virements)
    console.log(this.virements);
  }

}
