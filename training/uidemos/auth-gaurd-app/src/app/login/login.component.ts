import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService:Login) { }

  ngOnInit(): void {

  }
  onLogin =(loginForm:NgForm)=>{
    this.user=loginForm.value;
    console.log(loginForm.value);
    this
  }

}
