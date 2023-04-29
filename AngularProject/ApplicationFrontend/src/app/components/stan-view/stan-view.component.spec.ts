import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanViewComponent } from './stan-view.component';

describe('StanViewComponent', () => {
  let component: StanViewComponent;
  let fixture: ComponentFixture<StanViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StanViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StanViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
