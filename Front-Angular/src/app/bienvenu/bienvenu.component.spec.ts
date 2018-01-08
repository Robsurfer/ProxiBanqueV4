import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BienvenuComponent } from './bienvenu.component';

describe('BienvenuComponent', () => {
  let component: BienvenuComponent;
  let fixture: ComponentFixture<BienvenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BienvenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BienvenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
