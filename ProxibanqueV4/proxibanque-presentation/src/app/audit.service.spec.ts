import { TestBed, inject } from '@angular/core/testing';

import { AuditServiceService } from './audit-service.service';

describe('AuditServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AuditServiceService]
    });
  });

  it('should be created', inject([AuditServiceService], (service: AuditServiceService) => {
    expect(service).toBeTruthy();
  }));
});
