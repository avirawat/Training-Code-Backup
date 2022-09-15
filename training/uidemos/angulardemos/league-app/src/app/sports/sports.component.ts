import { Component, OnInit } from '@angular/core';
import { SportsService } from '../services/sports.service';

@Component({
  selector: 'ics-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent implements OnInit {

  sportsList=[]
  constructor(private _sportService:SportsService) { }

  ngOnInit(): void {
    this._sportService.getAllSports().subscribe(
      sports=>this.sportsList=sports,
      error=>console.log(error),
      ()=>console.log('completed')
    )
  }

}
