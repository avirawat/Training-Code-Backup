import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../model/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private _baseurl="http://localhost:8072/task-service"

  constructor(private _http:HttpClient) { }

  getAllServices():Observable<Task[]>{
    let url=this._baseurl+"/task"
    return this._http.get<Task[]>(url);
  }

  getById(taskId:number):Observable<Task>{
    let url=this._baseurl + "/task/taskId/" + taskId;
    return this._http.get<Task>(url)
  }
}
