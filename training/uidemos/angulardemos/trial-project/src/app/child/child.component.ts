import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

@Input() childOne=''
@Input() childTwo=''
@Input('childmess') childThree=''
@Input() childFour=''

@Output() childEventOne=new EventEmitter<string>()
@Output() childEventTwo=new EventEmitter<string>()
message:'have a good day'
showMessage = ()=>{
  this.childEventOne.emit('have a great day')
}
greetUser=(username:string)=>{
  this.childEventTwo.emit('Hello '+username)
}
  constructor() { }

  ngOnInit(): void {
  }

}
