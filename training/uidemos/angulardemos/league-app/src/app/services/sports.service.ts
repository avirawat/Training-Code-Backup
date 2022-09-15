import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sports } from '../model/sports';

@Injectable({
  providedIn: 'root'
})
export class SportsService {

  private _baseurl="http://localhost:9000/ics-sports-api"
  // private _sports:Sports[]=[
  //                   new Sports('Cricket',101,'England',''),
  //                   new Sports('Football',102,'Bercelona',''),
  //                   new Sports('Kabaddi',103,'India',''),
  //                 ]

  constructor(private http:HttpClient) { }
  getAllSports =():Observable<Sports[]>=>{
    let url=this._baseurl+"/sports";
    return this.http.get<Sports[]>(url);
  }
  }
