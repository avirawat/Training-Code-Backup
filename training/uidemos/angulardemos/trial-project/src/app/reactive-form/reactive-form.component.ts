import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {

    userForm:FormGroup
    cities=['Madurai','Chennai']
  user: any;
    constructor() { }

    ngOnInit(): void {
      this.userForm=new FormGroup({
        firstname:new FormControl('Sai',[Validators.required,Validators.minLength(5)]),
        lastname:new FormControl(''),
        acceptTerms:new FormControl(false),
        gender:new FormControl(''),
        address:new FormGroup({
        city:new FormControl(''),
        state:new FormControl('TN'),
        zipcode:new FormControl(0)
        })
      })
    }
    onRegister =()=>{
      console.log(this.userForm.value)
      this.user=this.userForm.value
      console.log(this.user)
    }

  }

