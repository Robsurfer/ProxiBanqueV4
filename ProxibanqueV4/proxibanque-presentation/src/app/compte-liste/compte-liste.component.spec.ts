import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteListeComponent } from './compte-liste.component';

describe('CompteListeComponent', () => {
  let component: CompteListeComponent;
  let fixture: ComponentFixture<CompteListeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteListeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteListeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
