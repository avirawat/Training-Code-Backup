import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Worker } from '../model/worker';

@Injectable({
  providedIn: 'root'
})
export class WorkerService {

  private _baseurl="http://localhost:8073/work-service"

  constructor(private _http:HttpClient) { }

  getAllWorker():Observable<Worker[]>{
    let url=this._baseurl+"/work"
    return this._http.get<Worker[]>(url);
  }

  getById(workerId:number):Observable<Worker>{
    let url=this._baseurl+"/work/"+workerId;
    return this._http.get<Worker>(url);
  }
}
