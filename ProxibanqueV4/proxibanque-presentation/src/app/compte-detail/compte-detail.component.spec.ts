import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteDetailComponent } from './compte-detail.component';

describe('CompteDetailComponent', () => {
  let component: CompteDetailComponent;
  let fixture: ComponentFixture<CompteDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
