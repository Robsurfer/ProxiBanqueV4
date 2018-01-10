import { Injectable } from '@angular/core';
import { ListeVirementService } from './listevirement.service';
import { Virement } from './virement';

@Injectable()
export class AuditService {

  virements: Virement[];

  constructor(private virementService: ListeVirementService) { }

  getVirements(){
    this.virementService.getVirementsAgence().subscribe(virements => this.virements = virements)
    console.log(this.virements);
  }

}
