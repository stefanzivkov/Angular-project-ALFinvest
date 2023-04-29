import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodavanjeStanaComponent } from './dodavanje-stana.component';

describe('DodavanjeStanaComponent', () => {
  let component: DodavanjeStanaComponent;
  let fixture: ComponentFixture<DodavanjeStanaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodavanjeStanaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DodavanjeStanaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
