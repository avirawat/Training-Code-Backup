import { Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appRenderHighlight]'
})
export class RenderHighlightDirective implements OnInit {

//Element help to get the element to which this directive is applied
//renderer helps to intercept the default behaviour and set style/class/attribute
  constructor(private _elementRef:ElementRef,private _renderer:Renderer2) { }

  ngOnInit():void{
    this._renderer.setStyle(this._elementRef.nativeElement,'color','green');
    this._renderer.setStyle(this._elementRef.nativeElement,'fontWeight','bold');
    this._renderer.addClass(this._elementRef.nativeElement,'header-style');

  }

}
