import { Injectable } from '@angular/core';
import { Team } from '../model/team';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private _baseurl="http://localhost:9000/ics-team-api"
  constructor(private _http:HttpClient) { }

  getAllTeams():Observable<Team[]>{
    let url=this._baseurl+"/teams"
    return this._http.get<Team[]>(url);
  }
  getById(teamId:number):Observable<Team>{
    let url = this._baseurl+"/teams/"+teamId
    return this._http.get<Team>(url);
  }

}
