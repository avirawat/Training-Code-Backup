import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { League } from '../model/league';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LeagueService {


  private _baseurl="http://localhost:9000/ics-league-api"

  constructor(private _http:HttpClient) { }

  getAllLeagues():Observable<League[]>{
    let url=this._baseurl+"/leagues"
    return this._http.get<League[]>(url);
  }
  getById(leagueId:number):Observable<League>{
    let url=this._baseurl+"/leagues/"+leagueId;
    return this._http.get<League>(url);
  }


}
