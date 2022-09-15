import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MyLibComponent } from './my-lib.component';



@NgModule({
  declarations: [MyLibComponent],
  imports: [
    BrowserModule
  ],
  exports: [MyLibComponent]
})
export class MyLibModule { }
