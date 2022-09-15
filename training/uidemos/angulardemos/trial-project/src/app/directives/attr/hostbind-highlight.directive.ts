import { Directive, HostBinding, HostListener, Input, OnInit } from '@angular/core';
import { Event } from '@angular/router';

@Directive({
  selector: '[appHostbindHighlight]'
})
export class HostbindHighlightDirective implements OnInit{

  @Input() defaultColor=''
  @Input() highlightColor=''
  @Input() textStyle=''
  @Input() highlightClass=''

  //decorator that marks a DOM property as a host binding property and
  //supplies consfiguration metadata.

  @HostBinding('style.color')fontColor=''
  @HostBinding('style.textTransform')changeText=''
  @HostBinding('style.backgroundColor')bgColor=''
  @HostBinding('class')addClass=''


  constructor() { }

  ngOnInit():void{
    this.fontColor=this.defaultColor
  }
  @HostListener('mouseenter') mouseEnter(event:Event) {
    this.fontColor=this.highlightColor
    this.changeText=this.textStyle
    this.bgColor='yellow'
    this.addClass=this.highlightClass
  }
  @HostListener('mouseleave') mouseExit(event:Event) {
    this.fontColor=this.defaultColor
    this.changeText='lowercase'
    this.bgColor=this.highlightColor
  }

}
