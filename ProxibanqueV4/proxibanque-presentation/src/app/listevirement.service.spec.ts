import { TestBed, inject } from '@angular/core/testing';

import { ListevirementService } from './listevirement.service';

describe('ListevirementService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ListevirementService]
    });
  });

  it('should be created', inject([ListevirementService], (service: ListevirementService) => {
    expect(service).toBeTruthy();
  }));
});
