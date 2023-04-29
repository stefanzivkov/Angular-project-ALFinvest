import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanItemComponent } from './stan-item.component';

describe('StanItemComponent', () => {
  let component: StanItemComponent;
  let fixture: ComponentFixture<StanItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StanItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StanItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
