import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees !: Employee[];

  searchText: any;

  constructor(private employeeService: EmployeeService,
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
    this.router.navigate([`employee-details`, id]);
  }

  updateEmployee(id: number){
    this.router.navigate([`update-employee`, id]);
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe( data =>{
      console.log(data);
      this.getEmployees();
      Swal.fire({
        color: 'red',
        position: 'center',
        icon: 'warning',
        title: 'Employee deleted; Are you Sure',
        showCancelButton: true,
        confirmButtonText:"Yes Delete it",
        cancelButtonText: "No Keep it"
      }).then((result) => {
        if (result.value) {
          Swal.fire(
            'Deleted!',
            'Your imaginary file has been deleted.',
            'success'
          );
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          Swal.fire(
            'Cancelled',
            'Your imaginary file is safe :)',
            'error'
          )
        }
      });

    })
  }

}
