import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AzuriranjeStanaComponent } from './azuriranje-stana.component';

describe('AzuriranjeStanaComponent', () => {
  let component: AzuriranjeStanaComponent;
  let fixture: ComponentFixture<AzuriranjeStanaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AzuriranjeStanaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AzuriranjeStanaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
