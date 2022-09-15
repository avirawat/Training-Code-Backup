import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { CoursesComponent } from './courses/courses.component';
import { HomeComponent } from './home/home.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

//this i san array of Route object
//Each Route object has certain properties
const routes: Routes = [
  {path:'home',component:HomeComponent},  //this is one route to home page
  {path:'aboutus',component:AboutusComponent},
  {path:'courses',component:CoursesComponent},
  {path:'course-details/:id',component:CourseDetailsComponent},
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'**',component:PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
