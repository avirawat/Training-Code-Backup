import { Component, OnInit } from '@angular/core';
import { CourseService } from '../services/course.service';
import { Course } from '../models/course';
import { Router } from '@angular/router';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  constructor(private _courseService:CourseService,private _router:Router) { }
courses=[]
//Router helps to navigate from one component to another
//naviagte to deatils component using Router
  ngOnInit(): void {
    this._courseService.getAllWithAppend()
   .subscribe(
     (coursesList)=>{this.courses = coursesList},
     (error)=>console.log("Error Occured"),
     ()=>console.log("Completed")
   );
  }
  onSearch=(course:Course)=> {
    console.log(course)
    //pass the route path And Param
    this._router.navigate(['/course-details',course.courseId])
  }

}
