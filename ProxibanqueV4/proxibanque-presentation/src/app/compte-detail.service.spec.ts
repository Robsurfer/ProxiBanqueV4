import { TestBed, inject } from '@angular/core/testing';

import { CompteDetailService } from './compte-detail.service';

describe('CompteDetailService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CompteDetailService]
    });
  });

  it('should be created', inject([CompteDetailService], (service: CompteDetailService) => {
    expect(service).toBeTruthy();
  }));
});
