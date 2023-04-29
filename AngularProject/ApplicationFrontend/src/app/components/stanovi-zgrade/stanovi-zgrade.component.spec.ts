import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanoviZgradeComponent } from './stanovi-zgrade.component';

describe('StanoviZgradeComponent', () => {
  let component: StanoviZgradeComponent;
  let fixture: ComponentFixture<StanoviZgradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StanoviZgradeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StanoviZgradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
