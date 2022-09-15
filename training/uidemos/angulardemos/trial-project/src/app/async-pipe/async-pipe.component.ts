import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../models/course';
import { CourseService } from '../services/course.service';

@Component({
  selector: 'app-async-pipe',
  templateUrl: './async-pipe.component.html',
  styleUrls: ['./async-pipe.component.css']
})
export class AsyncPipeComponent implements OnInit {

  courses:Observable<Course[]>
  constructor(private _courseService:CourseService) { }

  ngOnInit(): void {
        // assign the observable to this courses.
    // returning an observable to the template
    this.courses=this._courseService.getAllCourses();
  }

}
