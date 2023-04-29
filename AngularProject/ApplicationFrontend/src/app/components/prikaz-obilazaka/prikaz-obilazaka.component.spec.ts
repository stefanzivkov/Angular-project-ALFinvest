import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrikazObilazakaComponent } from './prikaz-obilazaka.component';

describe('PrikazObilazakaComponent', () => {
  let component: PrikazObilazakaComponent;
  let fixture: ComponentFixture<PrikazObilazakaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrikazObilazakaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrikazObilazakaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
