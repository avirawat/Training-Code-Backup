import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

  isLoggedIn:'root'
  isLoggedIn:boolean
  username:string
  
  constructor() {
    this.isLoggedIn=false;
   }
   loginUser=(username:string,password:string):Observable<boolean>=>{
      this.isLoggedIn=true;
      this.username=username
      return of(this.isLoggedIn);
   }
   logoutUSer=()=>{
     this.isLoggedIn=false
   }
}
