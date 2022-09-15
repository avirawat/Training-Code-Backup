import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './admin/login/login.component';
import { ContractDetailsComponent } from './contract-details/contract-details.component';
import { ContractComponent } from './contract/contract.component';
import { HomeComponent } from './home/home.component';
import { ResourceManagementComponent } from './resource-management/resource-management.component';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { TaskComponent } from './task/task.component';
import { WorkerDetailsComponent } from './worker-details/worker-details.component';
import { WorkerComponent } from './worker/worker.component';

const routes: Routes = [
  {path:"home",component:HomeComponent},
  {path:'admin',component:LoginComponent},
  {path:'contract',component:ContractComponent},
  {path:'resource-management',component:ResourceManagementComponent},
  {path:"contract-details/:id",component:ContractDetailsComponent},
  {path:"worker",component:WorkerComponent},
  {path:"worker-details/:id",component:WorkerDetailsComponent},
  {path:"task",component:TaskComponent},
  {path:"task-details/:id",component:TaskDetailsComponent},
  {path:'',redirectTo:'home',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
