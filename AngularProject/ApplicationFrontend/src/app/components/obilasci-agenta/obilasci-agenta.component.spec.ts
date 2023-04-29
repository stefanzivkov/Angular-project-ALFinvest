import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObilasciAgentaComponent } from './obilasci-agenta.component';

describe('ObilasciAgentaComponent', () => {
  let component: ObilasciAgentaComponent;
  let fixture: ComponentFixture<ObilasciAgentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObilasciAgentaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ObilasciAgentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
