import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanListComponent } from './stan-list.component';

describe('StanListComponent', () => {
  let component: StanListComponent;
  let fixture: ComponentFixture<StanListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StanListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StanListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
