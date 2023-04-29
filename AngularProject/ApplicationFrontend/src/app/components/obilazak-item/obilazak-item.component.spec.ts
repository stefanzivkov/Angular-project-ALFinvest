import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObilazakItemComponent } from './obilazak-item.component';

describe('ObilazakItemComponent', () => {
  let component: ObilazakItemComponent;
  let fixture: ComponentFixture<ObilazakItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObilazakItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObilazakItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
