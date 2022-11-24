import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { jsPDF } from "jspdf";
import "jspdf-autotable";


@Component({
  selector: 'app-employee-report',
  templateUrl: './employee-report.component.html',
  styleUrls: ['./employee-report.component.css']
})
export class EmployeeReportComponent implements OnInit {

@ViewChild('content', {static:false}) el!: ElementRef;


makePdf(){

  let pdf = new jsPDF('p', 'pt', 'a4');

  pdf.html(this.el.nativeElement, {
    callback: (pdf) => {

      pdf.save("sample.pdf");
    }
  })

}

  id!: number
  employee!: Employee

  constructor(private route: ActivatedRoute, private employeeService: EmployeeService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params[`id`];

    this.employee = new Employee();
    this.employeeService.getEmployeeById(this.id).subscribe( data => {
      this.employee = data;
    });
  }
  }
