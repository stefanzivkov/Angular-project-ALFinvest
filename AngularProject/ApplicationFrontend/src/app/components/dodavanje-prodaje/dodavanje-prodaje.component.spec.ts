import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodavanjeProdajeComponent } from './dodavanje-prodaje.component';

describe('DodavanjeProdajeComponent', () => {
  let component: DodavanjeProdajeComponent;
  let fixture: ComponentFixture<DodavanjeProdajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodavanjeProdajeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DodavanjeProdajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
