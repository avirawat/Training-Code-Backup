import { Component, OnInit } from '@angular/core';
import { Course } from '../models/course';

@Component({
  selector: 'app-attr-directive',
  templateUrl: './attr-directive.component.html',
  styleUrls: ['./attr-directive.component.css']
})
export class AttrDirectiveComponent implements OnInit {

  courses:Course[]=[
    new Course(1,'java',4000,'Backend'),
    new Course(2,'Angular',41000,'Web'),
    new Course(3,'Node',6000,'Frontend'),
    new Course(4,'Spring',8000,'Backend'),
    new Course(5,'HTML',1000,'Web'),

  ]
  constructor() { }

  ngOnInit(): void {
  }

}
