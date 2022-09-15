import { Component, OnInit } from '@angular/core';
import { interval, Observable } from 'rxjs';
import { take,map } from 'rxjs/operators';

@Component({
  selector: 'app-observe',
  templateUrl: './observe.component.html',
  styleUrls: ['./observe.component.css']
})
export class ObserveComponent implements OnInit {
  //internal creats an observable that emits sequential numbers
  //every sepcified interval of time

  numbers:Observable<number>=
                interval(1000)
                .pipe(take(10),map((num)=>num*5))





  constructor() { }

  ngOnInit(): void {
    //subscribe t0 get data
    this.numbers.subscribe(
      (value)=>console.log(value),
      (error)=>console.log(error),
      ()=>console.log('completed')
    )
  }

}
