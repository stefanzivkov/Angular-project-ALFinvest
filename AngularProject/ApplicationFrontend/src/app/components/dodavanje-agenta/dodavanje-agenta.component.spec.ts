import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodavanjeAgentaComponent } from './dodavanje-agenta.component';

describe('DodavanjeAgentaComponent', () => {
  let component: DodavanjeAgentaComponent;
  let fixture: ComponentFixture<DodavanjeAgentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodavanjeAgentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DodavanjeAgentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
