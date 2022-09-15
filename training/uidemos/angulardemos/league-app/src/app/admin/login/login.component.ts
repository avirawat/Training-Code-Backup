import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'ics-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login:"login";
  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  onLogin=(loginForm:NgForm)=>{
    console.log(loginForm.value)
    let user =loginForm.value;
  }

}
