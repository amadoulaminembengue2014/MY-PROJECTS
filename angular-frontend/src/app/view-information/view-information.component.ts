import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-view-information',
  templateUrl: './view-information.component.html',
  styleUrls: ['./view-information.component.css']
})
export class ViewInformationComponent implements OnInit {

  id!: number
  employee!: Employee
  
  constructor(private route: ActivatedRoute, private employeeService: EmployeeService,
   private router: Router) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params[`id`];

    this.employee = new Employee();
    this.employeeService.getEmployeeById(this.id).subscribe( data => {
      this.employee = data;
    });
  }

  employeeDetails(id: number){
    this.router.navigate([`view-information`, id]);
  }

  }


