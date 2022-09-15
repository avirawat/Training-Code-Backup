import { Injectable } from '@angular/core';
import { Player } from '../model/player';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private _baseurl="http://localhost:9000/ics-league-api"

  constructor(private _http:HttpClient) { }


  getPlayerByTeam(teamName:string):Observable<Player[]>{
    let url=this._baseurl+"/players/teams/"+teamName;
    return this._http.get<Player[]>(url);
  }
}
