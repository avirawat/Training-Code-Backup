import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Worker } from '../model/worker';
import { WorkerService } from '../services/worker.service';

@Component({
  selector: 'app-worker-details',
  templateUrl: './worker-details.component.html',
  styleUrls: ['./worker-details.component.css']
})
export class WorkerDetailsComponent implements OnInit {

  workerId: number;
  worker: Worker;
  constructor(
    private _workerService: WorkerService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      (map) => (this.workerId = parseInt(map.get('id')))
    );

    this._workerService.getById(this.workerId).subscribe((response) => {
      this.worker = response;
      console.log(this.worker);
    });
}
}
