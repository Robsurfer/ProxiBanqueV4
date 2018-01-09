import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavGaucheComponent } from './nav-gauche.component';

describe('NavGaucheComponent', () => {
  let component: NavGaucheComponent;
  let fixture: ComponentFixture<NavGaucheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavGaucheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavGaucheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
