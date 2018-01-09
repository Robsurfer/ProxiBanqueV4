import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VirementListeComponent } from './virement-liste.component';

describe('VirementListeComponent', () => {
  let component: VirementListeComponent;
  let fixture: ComponentFixture<VirementListeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VirementListeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VirementListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
