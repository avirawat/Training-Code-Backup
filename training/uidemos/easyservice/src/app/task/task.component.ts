import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Task } from '../model/task';
import { TaskService } from '../services/task.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  task:Task[]
  searchText=''
  constructor(private taskService:TaskService,private route:Router) { }

  ngOnInit(): void {
    this.taskService.getAllServices().subscribe(
      (servicesList)=>{
        this.task=servicesList;
        console.log(servicesList);
      },
      error =>console.log(error),
      ()=>console.log('completed')
    )
  }
  onSearch =(task:Task)=>{
    this.route.navigate(['/task-details',task.taskId])
}

}
