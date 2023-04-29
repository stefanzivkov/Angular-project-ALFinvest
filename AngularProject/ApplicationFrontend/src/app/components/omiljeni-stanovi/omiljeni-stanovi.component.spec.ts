import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OmiljeniStanoviComponent } from './omiljeni-stanovi.component';

describe('OmiljeniStanoviComponent', () => {
  let component: OmiljeniStanoviComponent;
  let fixture: ComponentFixture<OmiljeniStanoviComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OmiljeniStanoviComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OmiljeniStanoviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
