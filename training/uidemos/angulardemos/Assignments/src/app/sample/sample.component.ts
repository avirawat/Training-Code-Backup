import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sample',
  templateUrl: './sample.component.html',
  styleUrls: ['./sample.component.css']
})
export class SampleComponent implements OnInit {

student={
  name:'Avinash',
  age:24,
  hobbies:['Playing ',' listening music'],
  address:{
    city:'Ayodhya',
    state:'UP',
    mobile:'7991237314',
  },
}
mobiles=[
  {
  model:'realme xt',
  brand:'realme',
  price: 12000,
  os:'colorOs',
  ram:'snapdragon',
  rom:"8gb",
},
{
  model:'gaalxy',
  brand:'samsung',
  price: 15000,
  os:'colorOs',
  ram:'snapdragon',
  rom:"12gb",
},
]
newMobile=
  {
    model:'',
    brand:'',
    price:0,
    os:'',
    ram:'',
    rom:"",
}
showfeatures= (choice:string):void =>{
  this.mobiles.forEach((mobile) => {
    if(choice == mobile.model){
      this.newMobile = mobile;
    }
  });
}


  constructor() { }

  ngOnInit(): void {
  }

}
