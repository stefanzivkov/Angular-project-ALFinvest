import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZakazivanjeObilaskaComponent } from './zakazivanje-obilaska.component';

describe('ZakazivanjeObilaskaComponent', () => {
  let component: ZakazivanjeObilaskaComponent;
  let fixture: ComponentFixture<ZakazivanjeObilaskaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZakazivanjeObilaskaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZakazivanjeObilaskaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
