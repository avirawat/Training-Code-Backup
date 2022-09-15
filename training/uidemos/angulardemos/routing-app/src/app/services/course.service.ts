import { Injectable } from '@angular/core';
import { Course } from '../models/course';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  id:number
  private _url="assets/courses.json"
  constructor(private _httpClient:HttpClient) {

   }
   getAllCourse=():Observable<Course[]>=>{
    return this._httpClient.get<Course[]>(this._url);
   }

   //HttpRequest is asn immutable object
   //clone the http request to change it
   //httHeaders is asn immutable object

  //  getAllWithHeader =():Observable<Course[]> => {
  //    const header ={ 'cotent-type':'application/xml'}
  //    console.log(header);

  //    return this._httpClient.get<Course[]>(this._url,{'headers':header})
  //  }
  //  getAllWithHeaders =():Observable<Course[]> => {
  //    //header is immutable
  //    //if headers is already available -replace it
  //   const header =new HttpHeaders()
  //   .set('description','welcome')
  //   .set('content-type','text/html')
  //   .set('Accept',['text/html','application/xml']) //replaced the value
  //   console.log(header);

  //   return this._httpClient.get<Course[]>(this._url,{'headers':header})
  // }

  // getAllWithMulti =():Observable<Course[]> => {
  //   //header is immutable
  //   //if headers is already available -replace it
  //  let headers =new HttpHeaders()
  //  headers=headers.set('description','welcome')
  //  headers=headers.set('content-type','text/html')
  //  headers=headers.set('Accept',['text/html','application/xml']) //replaced the value
  //  console.log(headers);

  //  return this._httpClient.get<Course[]>(this._url,{'headers':headers})

//    getAllWithAppend =():Observable<Course[]> => {
//     //header is immutable
//     //if headers is already available -replace it
//    let headers =new HttpHeaders()
//    headers=headers.append('Custom-Header','zip')
//    headers=headers.append('Connection-details','live...')
//    headers=headers.append('Accept',['text/html','application/xml']) //replaced the value
//    console.log(headers);

//    return this._httpClient.get<Course[]>(this._url,{'headers':headers})
//  }
getAllWithAppend = ():Observable<Course[]>=>{
  let headers = new HttpHeaders();
  if(headers.has('Content-Type')) // check for a particular header
    headers = headers.set('custom-header','List of courses')

    headers = headers.set('Accept',['*/*','application/json']) // adds this as a new header
    headers = headers.append('Accept',['text/html','application/xml']) // appends to existing header
  console.log(headers);
  return this._httpClient.get<Course[]>(this._url,{'headers':headers})
}


}

