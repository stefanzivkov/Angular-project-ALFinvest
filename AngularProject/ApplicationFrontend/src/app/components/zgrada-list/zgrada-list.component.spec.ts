import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZgradaListComponent } from './zgrada-list.component';

describe('ZgradaListComponent', () => {
  let component: ZgradaListComponent;
  let fixture: ComponentFixture<ZgradaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZgradaListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZgradaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
