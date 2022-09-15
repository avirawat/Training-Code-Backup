import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ContractComponent } from './contract/contract.component';
import { MaintenanceComponent } from './maintenance/maintenance.component';
import { TaskComponent } from './task/task.component';
import { WorkerComponent } from './worker/worker.component';
import { HttpClientModule } from '@angular/common/http';
import { WorkerDetailsComponent } from './worker-details/worker-details.component';
import { TaskDetailsComponent } from './task-details/task-details.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { ContractDetailsComponent } from './contract-details/contract-details.component';
import { ResourceManagementComponent } from './resource-management/resource-management.component';
import { StatuspipePipe } from './pipes/statuspipe.pipe';
import { HeaderComponent } from './header/header.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContractComponent,
    MaintenanceComponent,
    TaskComponent,
    WorkerComponent,
    WorkerDetailsComponent,
    TaskDetailsComponent,
    ContractDetailsComponent,
    ResourceManagementComponent,
    StatuspipePipe,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
