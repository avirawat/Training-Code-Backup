import { Component, OnInit} from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-observe-string',
  templateUrl: './observe-string.component.html',
  styleUrls: ['./observe-string.component.css']
})
export class ObserveStringComponent implements OnInit {

myObservables:Observable<string>=new Observable((subscriber)=>{
  subscriber.next("apple"),
  setTimeout(()=>subscriber.next("orange"),2000);
  setTimeout(()=>subscriber.next("pine"),3000);
  setTimeout(()=>subscriber.next("banana"),4000);
  setTimeout(()=>subscriber.next("Apple"),1000);
  setTimeout(()=>subscriber.next("kiwi"),6000);

  subscriber.next("pine"),
  subscriber.next("banana"),
  //subscriber.error('error occured'),
  subscriber.next("kiwi"),
  subscriber.next("berry"),
  subscriber.next("cherry"),
  subscriber.next("grapes"),
  setTimeout(()=>subscriber.complete(),4000)
})

  constructor() { }

  ngOnInit(): void {
    this.myObservables
    .pipe(map(fruit=>fruit.toUpperCase()))
    .subscribe(
      (value)=>console.log(value),
      (error)=>console.log(error),
      ()=>console.log('completed')
    )

    this.myObservables
    .pipe(map(fruit=>fruit.length))
    .subscribe(
      (value)=>console.log(value),
      (error)=>console.log(error),
      ()=>console.log('completed')
    )
  }

}
