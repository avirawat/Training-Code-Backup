import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Worker } from '../model/worker';
import { WorkerService } from '../services/worker.service';

@Component({
  selector: 'app-worker',
  templateUrl: './worker.component.html',
  styleUrls: ['./worker.component.css']
})
export class WorkerComponent implements OnInit {

  filter = {available : false, notavailable: false};
  workers:Worker[]
  filteredWorker:Worker[]=[]
  searchText=''
  constructor(private workerService:WorkerService,private route:Router) { }

  ngOnInit(): void {
    this.workerService.getAllWorker().subscribe(
      (workerList)=>{
        this.workers=workerList;
       console.log(workerList);
      },
      error =>console.log(error),
      ()=>console.log('completed')
    )
  }

  onSearch =(worker:Worker)=>{
    this.route.navigate(['/worker-details',worker.workerId])
}

filterChange() {
  this.filteredWorker=this.workers.filter(worker=>
    (worker.availability==='Available' && this.filter.available)
    ||  (worker.availability==='Not-Available' && this.filter.notavailable)
    );
    console.log(this.filteredWorker)
    console.log(this.workers)
    if(this.filteredWorker.length!=this.workers.length){
        this.workers = this.filteredWorker;
    }
}
  }
