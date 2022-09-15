import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyLibService {

  private _courses=['java','Angular','React','Python']

  constructor() { }
  showCourses = ()=>{
    return this._courses;
  }
}
