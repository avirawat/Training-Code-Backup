import { Directive, ElementRef, HostListener, OnInit, Renderer2 } from '@angular/core';
import { Event } from '@angular/router';

@Directive({
  selector: '[appHostHighlight]'
})
export class HostHighlightDirective implements OnInit{

  // this directive is created to handle events

  constructor(private _elementRef:ElementRef,private _renderer:Renderer2) { }

  ngOnInit():void{
    this._renderer.setStyle(this._elementRef.nativeElement,'color','blue');
  }
  // events here is mousenter
  //host listener listens to the mouse enter evenet that happpens
  //in the element that has this directive
  @HostListener('mouseenter') mouseEnter(event:Event){
    this._renderer.setStyle(this._elementRef.nativeElement,'backgroundColor','yellow');
    this._renderer.setStyle(this._elementRef.nativeElement,'textTransform','uppercase');

  }
  //events here is mouseleave
  @HostListener('mouseleave') mouseExit(event:Event){
    this._renderer.setStyle(this._elementRef.nativeElement,'backgroundColor','pink');
    this._renderer.setStyle(this._elementRef.nativeElement,'textTransform','lowercase');

  }
}
