import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VirementDetailComponent } from './virement-detail.component';

describe('VirementDetailComponent', () => {
  let component: VirementDetailComponent;
  let fixture: ComponentFixture<VirementDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VirementDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VirementDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
