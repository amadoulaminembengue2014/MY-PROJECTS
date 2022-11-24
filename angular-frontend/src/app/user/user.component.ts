import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  employees !: Employee[];

  searchText: any;
  
  constructor(private route: ActivatedRoute, private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit(): void {

    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeesList().subscribe( data => {
      this.employees = data;
    });

  }

  employeeDetails(id: number){
    this.router.navigate([`view-information`, id]);
  }

  }
