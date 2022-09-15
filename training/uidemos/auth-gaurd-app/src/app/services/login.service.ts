import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  isLoggedIn:boolean
  username:string

  constructor() {
    this.isLoggedIn=false
  }
  isUserLoggedIn = ():boolean=>{
    return this.isLoggedIn;
  }

  loginUser = (username:string,password:string):Observable<boolean>=>{
    // call the backend to check username and password
    this.isLoggedIn=true;
    this.username=username
    // return an observable of true/false value
    return of(this.isLoggedIn);
  }

  logoutUser = ()=>{
    this.isLoggedIn = false;
  }

}
