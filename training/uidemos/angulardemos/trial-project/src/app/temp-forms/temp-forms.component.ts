import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../model/user';

@Component({
  selector: 'app-temp-forms',
  templateUrl: './temp-forms.component.html',
  styleUrls: ['./temp-forms.component.css']
})
export class TempFormsComponent implements OnInit {

  cities = ['Mangalore','Ooty','Chennai','Munnar']
  states=['KAR','UP']

  user:User;
  //registerForm is the name of the template ref variable
  //regForm is the  instance of ngForm
  @ViewChild('registerForm')regForm:NgForm
  constructor() { }

  ngOnInit(): void {
    this.user ={
      firstname:'',
      lastname:'',
      gender:'',
      email:'',
      acceptTerms:false,
      address:{
        city:'',
        state:'',
        zipcode:0
      }
    }

  }
setValues = ()=>{
  this.regForm.setValue(this.user)
}
setPartValues=()=>{
  let obj = {
    firstname:'R',
    acceptTerms:true,
    address:{
      state:'KAR'
    }
  }
  this.regForm.control.patchValue(obj);
}

 onRegister = (registerForm:NgForm)=>{

  console.log(registerForm.value)
 }
}
