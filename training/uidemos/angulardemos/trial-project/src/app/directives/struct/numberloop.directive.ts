import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appNumberloop]'
})
export class NumberloopDirective {

  @Input() set appNumberloop(Loop:number) {
    for(let index=0;index<Loop;index++) {
      this.viewContainer.createEmbeddedView(this.templateRef)
    }
  }




  constructor(private templateRef:TemplateRef<any>,private viewContainer:ViewContainerRef) {

   }

}
