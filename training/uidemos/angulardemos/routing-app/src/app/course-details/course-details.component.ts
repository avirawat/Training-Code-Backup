import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../models/course';
import { CourseService } from '../services/course.service';

@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit {

  id:number
  course:Course ={courseId: 0, courseName: '', courseType: '', cost: 9000}
  //Activated Routes Contains the information about a route
  //associated with a currently loaded component
  constructor(private _courseService:CourseService,
              private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(map=>{
     this.id = parseInt(map.get("id")) //this id is from the path in routes array
    })

    this._courseService.getAllCourse()
    .subscribe(courseList=>{
      courseList.forEach((ncourse)=>{
        if(ncourse.courseId==this.id){
          this.course=ncourse;
          console.log(this.course.courseName)
        }
      }
      )
    })

  }


}
