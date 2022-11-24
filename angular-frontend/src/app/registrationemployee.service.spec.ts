import { TestBed } from '@angular/core/testing';

import { RegistrationemployeeService } from './registrationemployee.service';

describe('RegistrationemployeeService', () => {
  let service: RegistrationemployeeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistrationemployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
