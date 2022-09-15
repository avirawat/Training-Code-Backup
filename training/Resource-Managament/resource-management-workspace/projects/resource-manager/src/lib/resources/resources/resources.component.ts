import { Component, OnInit , Input} from '@angular/core';
import { Resource } from '../../models/resources/resource';

@Component({
  selector: 'lib-resources',
  templateUrl: './resources.component.html',
  styleUrls: ['./resources.component.scss'],
})
export class ResourcesComponent implements OnInit {

  panelOpenState: boolean = false;
  currentWeekTasks: any = [];
  currentMonthTasks: any = [];
  weekDate: Date = new Date();
  monthDate: any = new Date();

  @Input() resources: Resource[] = [];

  constructor() {

  }

  ngOnInit(): void {

  }
}
