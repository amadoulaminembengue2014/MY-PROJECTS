import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm! : FormGroup

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {


    this.signupForm = this.formBuilder.group({
      firstName: new FormControl('',[Validators.required, Validators.pattern('[a-zA-Z]+$')]),
      lastName: new FormControl('' ,[Validators.required, Validators.pattern('[a-zA-Z]+$')]),
      emailId: new FormControl('' ,[Validators.required, Validators.email]),
      password: new FormControl('',[Validators.required, Validators.minLength(5)]),
    })
  }

  signUp(){
    console.warn(this.signupForm.value)

    this.http.post<any>("http://localhost:8080/api/v1/employees", 
    this.signupForm.value).subscribe(res=>{
      
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Registration Successfull',
        showConfirmButton: false,
        timer: 8000
      })

      this.signupForm.reset();
      this.router.navigate(['login'])
    }, err =>{
      Swal.fire("Error")
    })
  }


  get firstName(){
    return this.signupForm.get('firstName')
  }

  get lastName(){
    return this.signupForm.get('lastName')
  }

  get emailId(){
    return this.signupForm.get('emailId')
  }

  get password(){
    return this.signupForm.get('password')
  }

}
