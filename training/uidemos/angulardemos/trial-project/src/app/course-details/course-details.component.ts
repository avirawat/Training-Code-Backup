import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service';


@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {

  courses=[]
// injecting CourseService into the component
  constructor(private _courseService:CourseService) { }

  ngOnInit(): void {
    this._courseService.getAllCourses().subscribe(
      (courseList)=>this.courses=courseList,
      error=>console.log(error),
      ()=>console.log('completed')
    )
  }

}
