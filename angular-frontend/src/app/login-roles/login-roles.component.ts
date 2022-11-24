import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login-roles',
  templateUrl: './login-roles.component.html',
  styleUrls: ['./login-roles.component.css']
})
export class LoginRolesComponent implements OnInit {

  loginForm! : FormGroup

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({
      firstName: new FormControl('',[Validators.required, Validators.pattern('[a-zA-Z]+$')]),
      lastName: new FormControl('' ,[Validators.required, Validators.pattern('[a-zA-Z]+$')]),
      email: new FormControl('' ,[Validators.required, Validators.email]),
      password: new FormControl('',[Validators.required, Validators.minLength(5)]),
    })
  }

  login() {

    console.warn(this.loginForm.value)

    this.http.get<any>("http://localhost:8080/api/users").subscribe(res => {
      const User = res.find((a: any) => {
        return a.email == this.loginForm.value.email && a.password == this.loginForm.value.password
      })
      if (User) {
        alert("Login is Successfull 0  #WELCOM");
        this.loginForm.reset();
        this.router.navigate(['welcome'])
      } else {
        alert('User Not Found !!')
      }
    }, err => {
      alert('With success')
      this.router.navigate(['welcome'])
    },
    )
  }
  


  get firstName(){
    return this.loginForm.get('firstName')
  }

  get lastName(){
    return this.loginForm.get('lastName')
  }

  get email(){
    return this.loginForm.get('email')
  }

  get password(){
    return this.loginForm.get('password')
  }

}
