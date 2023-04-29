import { TestBed } from '@angular/core/testing';

import { StanService } from './stan.service';

describe('StanService', () => {
  let service: StanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
