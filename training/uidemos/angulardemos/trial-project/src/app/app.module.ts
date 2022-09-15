import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DataBindingComponent } from './data-binding/data-binding.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { StrDirectivesComponent } from './str-directives/str-directives.component';
import { StrDirectComponent } from './str-direct/str-direct.component';
import { AttrDirectiveComponent } from './attr-directive/attr-directive.component';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';
import { BasicHighlightDirective } from './directives/attr/basic-highlight.directive';
import { CustomDirectivesComponent } from './custom-directives/custom-directives.component';
import { RenderHighlightDirective } from './directives/attr/render-highlight.directive';
import { HostHighlightDirective } from './directives/attr/host-highlight.directive';
import { HostbindHighlightDirective } from './directives/attr/hostbind-highlight.directive';
import { NotifDirective } from './directives/struct/notif.directive';
import { NumberloopDirective } from './directives/struct/numberloop.directive';
import { CustomPipesComponent } from './custom-pipes/custom-pipes.component';
import { TitlePipe } from './pipes/title.pipe';
import { ReversePipe } from './pipes/reverse.pipe';
import { TimePipe } from './pipes/time.pipe';
import { FilterPipe } from './pipes/filter.pipe';
import { LifecycleComponent } from './lifecycle/lifecycle.component';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { ObserveComponent } from './observe/observe.component';
import { ObserveStringComponent } from './observe-string/observe-string.component';
import { HttpClientModule } from '@angular/common/http';
import { TempFormsComponent } from './temp-forms/temp-forms.component';
import { ReactiveFormComponent } from './reactive-form/reactive-form.component';
import { AsyncPipeComponent } from './async-pipe/async-pipe.component';

@NgModule({
  declarations: [
    AppComponent,
    DataBindingComponent,
    StrDirectivesComponent,
    StrDirectComponent,
    AttrDirectiveComponent,
    ParentComponent,
    ChildComponent,
    BasicHighlightDirective,
    CustomDirectivesComponent,
    RenderHighlightDirective,
    HostHighlightDirective,
    HostbindHighlightDirective,
    NotifDirective,
    NumberloopDirective,
    CustomPipesComponent,
    TitlePipe,
    ReversePipe,
    TimePipe,
    FilterPipe,
    LifecycleComponent,
    CourseDetailsComponent,
    ObserveComponent,
    ObserveStringComponent,
    TempFormsComponent,
    ReactiveFormComponent,
    AsyncPipeComponent
  ],
  imports: [
    BrowserModule,FormsModule,HttpClientModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
