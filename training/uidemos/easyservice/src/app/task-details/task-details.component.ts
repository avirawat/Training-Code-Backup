import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Task } from '../model/task';
import { TaskService } from '../services/task.service';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  taskId: number;
  service: Task;
  constructor(
    private taskService: TaskService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      (map) =>{
        this.taskId = parseInt(map.get("id"))
  });

    this.taskService.getById(this.taskId).subscribe(
      (task) => {
      this.service = task;
      console.log(task);
    });
}

}
