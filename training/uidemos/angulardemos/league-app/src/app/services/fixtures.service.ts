import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fixtures } from '../model/fixtures';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class FixtureService {
  private _baseurl="http://localhost:9000/ics-fixtures-api"

  constructor(private _http:HttpClient) { }

  getAllFixtures():Observable<Fixtures[]>{
    let url=this._baseurl+"/fixtures";
    return this._http.get<Fixtures[]>(url);
  }
  getById(fixturesId:number):Observable<Fixtures>{
    let url=this._baseurl+"/fixtures/"+fixturesId;
    return this._http.get<Fixtures>(url);
  }
}
