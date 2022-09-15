import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';

@Component({
  selector: 'app-str-direct',
  templateUrl: './str-direct.component.html',
  styleUrls: ['./str-direct.component.css']
})
export class StrDirectComponent implements OnInit {

courses:Course[]=[
  new Course(1,'java',4000,'Backend'),
  new Course(2,'Angular',41000,'Web'),
  new Course(3,'Node',6000,'Frontend'),
  new Course(4,'Spring',8000,'Backend'),
  new Course(5,'HTML',1000,'Web'),

]
myclass='header';
newclass='checker';
fnewclass='front';
bnewclass='back';
  constructor() { }

  ngOnInit(): void {
  }

}
