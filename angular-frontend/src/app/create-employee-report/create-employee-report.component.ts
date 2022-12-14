import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee-report',
  templateUrl: './create-employee-report.component.html',
  styleUrls: ['./create-employee-report.component.css']
})
export class CreateEmployeeReportComponent implements OnInit {

  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList(){
this.router.navigate([`/employees`]);
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

}
