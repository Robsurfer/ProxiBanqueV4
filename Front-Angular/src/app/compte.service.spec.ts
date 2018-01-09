import { TestBed, inject } from '@angular/core/testing';

import { CompteService } from './compte.service';

describe('CompteService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CompteService]
    });
  });

  it('should be created', inject([CompteService], (service: CompteService) => {
    expect(service).toBeTruthy();
  }));
});
