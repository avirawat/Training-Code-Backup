import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  // template:`
  // <h3 [class.article]='applyClass'>{{employee.name}}</h3>
  // <h4>{{message}}</h4>
  // <h4 [class]='myClass'>{{message}}</h4>
  // `,
  // styles:[
  //   `
  //   .header{
  //     background-color:yellow;
  //     color:green;
  //   }
  //   .article{
  //     letter-spacing:2px;
  //     text-transform:uppercase;
  //     color:orange;
  //   }
  //   `
  // ]
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

  employee={
    name:'POOH',
    salary:20000
  }
  imageName='assets/images/poooh.png'
  buttonStatus=false;

  message='Have a great day'


myClass='header' //points to the class header in css
applyClass=true //implies whetgher the given css class to be applied or not

mycolor='orange'
applyColor=true
uname:string='jhonny'
  changeMessage= ():void=> {
    this.message='Good Day';
  }

  greet=(username:string):void=> {
    this.message='welcome '+username;
  }

  // show(){
  //   this.message='hello '+this.uname;
  // }

  constructor() { }

  ngOnInit(): void {
  }

}
