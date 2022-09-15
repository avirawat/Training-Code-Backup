import { AfterViewChecked, AfterViewInit, Component, ElementRef, Input, OnInit, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { ChildComponent } from '../child/child.component';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit,AfterViewInit,AfterViewChecked {
//use this to access to custom child component
  @ViewChild(ChildComponent)
  childComponent:ChildComponent

  //to access th other chilc component.pass the reference name of the element
  @ViewChild("header")myheader:ElementRef

// to access multiple references of child component
  // many children  so use ViewChildren
  // many elements so use QueryList<ElementRef>

  @ViewChildren("newheader")allheaders:QueryList<ElementRef>

  @Input() parentMessOne='Message from Parent One'
  parentMessTwo='Message from Parent Two'
  parentmodel=''

  childMessOne=''
  childMessTwo=''

  constructor() { }

  ngOnInit(): void {
    //child is still not loaded
    console.log("Hello")
    console.log(this.childComponent)
    console.log(this.myheader)
  }
  ngAfterViewInit():void{
    console.log(this.childComponent);
    console.log(this.childComponent.message);

    console.log(this.myheader.nativeElement);
    console.log(this.childComponent.childOne)
    console.log(this.myheader.nativeElement);
    this.myheader.nativeElement.style.backgroundColor="red"

    //access all headers with the ref name header
    this.allheaders.forEach(elementRef=>{
      console.log(this.myheader.nativeElement);
      elementRef.nativeElement.style.textTransform='uppercase'
    })
    //console.log()
    //data ius taken from parent to chikd and getting
    // console.log(this.childComponent.childOne);
    // console.log(this.childComponent.childThree);
    // console.log(this.childComponent.childFour);


  }
  ngAfterViewChecked():void{
    // console.log(this.childComponent.message);
    // console.log(this.childComponent.childOne);
    // console.log(this.childComponent.childTwo);
    // console.log(this.childComponent.childThree);
    // console.log(this.childComponent.childFour);



  }

}
