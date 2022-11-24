import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

  employees !: Employee[];
  searchText: any;
  firstName!: string;
  name!: string;

  constructor(private employeeService: EmployeeService,
    private router: Router) { 
      this.name = "Lamine";
    }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe( data => {
      this.employees = data;
    });

  }

  employeeReport(id: number){
    this.router.navigate([`employee-report`, id]);
  }

  updateEmployee(id: number){
    this.router.navigate([`update-employee`, id]);
  }

  updateReport(id: number){
    this.router.navigate([`update-report`, id]);
  }
  
  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe( data =>{
      console.log(data);
      this.getEmployees();
    })
  }

}
