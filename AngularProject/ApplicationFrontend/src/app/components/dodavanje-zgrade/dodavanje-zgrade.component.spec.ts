import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodavanjeZgradeComponent } from './dodavanje-zgrade.component';

describe('DodavanjeZgradeComponent', () => {
  let component: DodavanjeZgradeComponent;
  let fixture: ComponentFixture<DodavanjeZgradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodavanjeZgradeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DodavanjeZgradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
