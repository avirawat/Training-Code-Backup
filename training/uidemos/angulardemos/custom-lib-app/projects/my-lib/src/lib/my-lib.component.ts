import { Component, OnInit } from '@angular/core';
import { MyLibService } from './my-lib.service';

@Component({
  selector: 'lib-my-lib',
  template: `
  <h3>Available Courses from {{title}}</h3>
  <h4 *ngFor='let course of courseList'>
  <h3>{{course|uppercase}}</h3>
  </h4>
  `,
  styles: [
  ]
})
export class MyLibComponent implements OnInit {

  title=''
  courseList=[]

  constructor(private _libService:MyLibService) { }

  ngOnInit(): void {
    this.title='Custom Library'
    this.courseList=this._libService.showCourses();
  }

}
