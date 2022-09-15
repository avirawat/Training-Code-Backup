import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-str-directives',
  templateUrl: './str-directives.component.html',
  styleUrls: ['./str-directives.component.css']
})
export class StrDirectivesComponent implements OnInit {

  username='Priya'
  uname:string
  hstyle='header-style'
  cstyle='checker-style'
  mystyle='none'
  vehicles=['car','bike','truck','scooter','tampoo']

  constructor() { }

  ngOnInit(): void {
  }

}
