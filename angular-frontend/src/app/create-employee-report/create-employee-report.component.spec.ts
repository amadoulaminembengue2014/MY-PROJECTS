import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEmployeeReportComponent } from './create-employee-report.component';

describe('CreateEmployeeReportComponent', () => {
  let component: CreateEmployeeReportComponent;
  let fixture: ComponentFixture<CreateEmployeeReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateEmployeeReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateEmployeeReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
