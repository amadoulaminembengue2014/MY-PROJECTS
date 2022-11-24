import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  employee= new Employee();
  loginForm!: FormGroup;

  constructor(private service: EmployeeService ,private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      emailId: ['' ,[Validators.required, Validators.email]],
      password: ['' ,[Validators.required, Validators.minLength(5)]],
    })
  }

  loginEmployee() {

    


    console.warn(this.loginForm.value)

    this.http.get<any>("http://localhost:8080/api/v1/employees").subscribe(res => {
      const Employee = res.find((a: any) => {
        return a.emailId == this.loginForm.value.emailId && a.password == this.loginForm.value.password
      })
      if (Employee) {
        Swal.fire({
          color: 'green',
          position: 'center',
          icon: 'success',
          title: 'login successful #Welcom',
          showConfirmButton: false,
         
        })
  
        this.loginForm.reset();
        this.router.navigate(['home-user'])
      } else {
        Swal.fire({
          color: 'red',
          position: 'center',
          icon: 'warning',
          title: 'Employee Not Found, Please try again',
          showConfirmButton: false,
          
        })
  
        
      }
    }, err => {
      Swal.fire('Error')
    },
    )
  }


  get emailId(){
    return this.loginForm.get('emailId')
  }

  get password(){
    return this.loginForm.get('password')
  }

}
