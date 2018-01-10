import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EtatRequeteComponent } from './etat-requete.component';

describe('EtatRequeteComponent', () => {
  let component: EtatRequeteComponent;
  let fixture: ComponentFixture<EtatRequeteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EtatRequeteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EtatRequeteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
