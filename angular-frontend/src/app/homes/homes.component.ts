import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-homes',
  templateUrl: './homes.component.html',
  styleUrls: ['./homes.component.css']
})
export class HomesComponent implements OnInit {

  myimage:string = "assets/image/ooooooo.jpg";

  constructor() { }

  ngOnInit(): void {
  }

}
