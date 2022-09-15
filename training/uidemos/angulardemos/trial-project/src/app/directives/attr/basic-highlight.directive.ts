import { Directive, ElementRef, OnInit } from '@angular/core';

@Directive({
  selector: '[appBasicHighlight]'
})
export class BasicHighlightDirective implements OnInit{

  constructor(private _elementRef:ElementRef) { }

  ngOnInit(){
    this._elementRef.nativeElement.style.backgroundColor='indigo'
    this._elementRef.nativeElement.style.textTransform='uppercase'
  }
}

