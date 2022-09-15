import { AfterContentChecked, AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, OnChanges, OnDestroy, OnInit, SimpleChange, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-lifecycle',
  templateUrl: './lifecycle.component.html',
  styleUrls: ['./lifecycle.component.css']
})
export class LifecycleComponent implements OnInit,
                                            OnChanges,
                                            DoCheck,
                                            AfterContentInit,
                                            AfterContentChecked,
                                            AfterViewInit,
                                            AfterViewChecked,
                                            OnDestroy
                                            {

  username = 'Priya'
  constructor() {
  console.log("in const ")
  }
   ngOnChanges(changes: SimpleChanges): void {
    console.log(`called on every change ${this.username}`)
  }
  // invoked immediately after the default change detector has checked the directive's
  // data-bound properties for the first time

  ngOnInit(): void {
    console.log(`Initialized and called once ${this.username}` )
  }
  //  invoked after the default change-detector runs.
  ngDoCheck():void{
    console.log(` do checking  ${this.username}` )
  }
  // immediately after Angular has completed initialization
  // of all of the directives content.
  // called only once
  ngAfterContentInit(): void {
    console.log(`content initialized`)

  }
  ngAfterContentChecked():void{
    console.log(`after content checking ${this.username}`)
  }
  // invoked immediately after Angular has completed initialization
  //  of a component's view.
  //  It is invoked only once when the view is instantiated.
  ngAfterViewInit(): void {
    console.log(`view initialized  ${this.username}` )

  }
  // invoked immediately after the default change detector has completed
  //  one change-check cycle for a component's view.
  ngAfterViewChecked(): void {
    console.log(`view checked  ${this.username}` )
  }
  // invoked immediately  before a directive, pipe, or service instance is destroyed.
  ngOnDestroy(): void {
    console.log(`in destroy` )
  }
}
