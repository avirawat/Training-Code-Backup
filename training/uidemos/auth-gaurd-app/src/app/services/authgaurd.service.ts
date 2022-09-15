import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthgaurdService implements CanActivate{

  constructor(private loginService:LoginService,private router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
    if(!this.loginService.isUserLoggedIn){
      alert('Please login');
      this.router.navigate(["/login"],{queryParams:{returl:route.url}})
      return false
    }
    return true;
  }


}
