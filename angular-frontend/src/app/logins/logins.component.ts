import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-logins',
  templateUrl: './logins.component.html',
  styleUrls: ['./logins.component.css']
})
export class LoginsComponent implements OnInit {

  
  loginsForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit() {

    this.loginsForm = this.formBuilder.group({
      emailId: new FormControl ( '' ,[Validators.required, Validators.email]),
      password: new FormControl ('' ,[Validators.required, Validators.minLength(5)]),
      role: new FormControl ('' ,[Validators.required, Validators.pattern('[a-zA-Z]+$')]),
    })

  }

  logins() {

    console.warn(this.loginsForm.value)

    this.http.post<any>("http://localhost:8080/api/admin", 
    this.loginsForm.value).subscribe(res=>{
      Swal.fire('Login ADMIN Successfull');
      this.loginsForm.reset();
      this.router.navigate(['home'])
    }, err =>{
      Swal.fire("Error")
    })
  }


  get emailId(){
    return this.loginsForm.get('emailId')
  }

  get password(){
    return this.loginsForm.get('password')
  }

  get role(){
    return this.loginsForm.get('role')
  }

  
}
