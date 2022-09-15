import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  // courseArray:Course[]=[
  //   new Course(1,'Java',4000,'Backend'),
  //   new Course(2,'Angular',14000,'Web'),
  //   new Course(4,'Spring',8000,'Backend'),
  //   new Course(3,'Node',6000,'Web'),
  //   new Course(5,'DBMS',5000,'Backend'),
  //   new Course(6,'HTML',1000,'Web'),
  //   new Course(7,'CSS',1000,'Frontend'),
  //   new Course(8,'JS',2000,'Frontend')

  // ]

  private _url="/assets/courses.json"
  constructor(private _http:HttpClient) {

  }

  getAllCourses=():Observable<Course[]>=> {
      return this._http.get<Course[]>(this._url)
  }
}
