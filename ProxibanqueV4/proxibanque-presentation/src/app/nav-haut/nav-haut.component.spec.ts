import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavHautComponent } from './nav-haut.component';

describe('NavHautComponent', () => {
  let component: NavHautComponent;
  let fixture: ComponentFixture<NavHautComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavHautComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavHautComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
