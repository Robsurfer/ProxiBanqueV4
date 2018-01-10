import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConseillersComponent } from './conseillers.component';

describe('ConseillersComponent', () => {
  let component: ConseillersComponent;
  let fixture: ComponentFixture<ConseillersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConseillersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConseillersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
