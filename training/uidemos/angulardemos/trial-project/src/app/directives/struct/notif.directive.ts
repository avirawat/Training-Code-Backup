import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appNotif]'
})
export class NotifDirective {
  //setter method for appNotIf
  @Input() set appNotif(condition:boolean){
    if(!condition)
   // create an embedded view using ViewContainerRef
     //  Instantiate an embedded view and insert it into this container.
     //Add the template inside the embedded view

    this.viewContainer.createEmbeddedView(this.templateRef)
    else{
      this.viewContainer.clear()
    }

  }
  // A container can have many views.
  // Embedded views can be created and added to a container
  // Templates can be added inside the views using templateRef
  // Represents a container where one or more views can be attached to a component.

  constructor(private templateRef:TemplateRef<any>,private viewContainer:ViewContainerRef) {

  }

}
