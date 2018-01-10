import { Injectable } from '@angular/core';
import { VirementService } from './virement.service';
import { Virement } from './virement';

@Injectable()
export class AuditService {

  virements: Virement[];

  constructor(private virementService: VirementService) { }

  getVirements(){
    this.virementService.getVirementsAgence().subscribe(virements => this.virements = virements)
    console.log(this.virements);
  }

}
