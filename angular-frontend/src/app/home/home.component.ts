import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  myimage:string = "assets/image/mana.jpeg";

  constructor() { }

  ngOnInit(): void {
  }

}
