import { TestBed } from '@angular/core/testing';

import { GymserviceService } from './gymservice.service';

describe('GymserviceService', () => {
  let service: GymserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GymserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
