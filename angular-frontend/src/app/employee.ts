import { NgLocalization } from "@angular/common";

export class Employee {
    id!: number;
    firstName!: string;
    lastName!: string;
    dateOfBirth!: Date;
    emailId!: string;
    telephone!: string;
    address!: string;
    department!: string;
    gender!: string;
    salary!: string;
    dateHired!: NgLocalization;
    jobTitle!: string;
    image!: string;
    password!: string;
  find: any;
  employee_id: any;


  constructor(){}
}
