import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompteCreationComponent } from './compte-creation.component';

describe('CompteCreationComponent', () => {
  let component: CompteCreationComponent;
  let fixture: ComponentFixture<CompteCreationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompteCreationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompteCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
