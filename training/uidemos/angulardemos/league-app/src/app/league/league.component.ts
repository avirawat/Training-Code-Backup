import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { League } from '../model/league';
import { LeagueService } from '../services/league.service';

@Component({
  selector: 'ics-league',
  templateUrl: './league.component.html',
  styleUrls: ['./league.component.css']
})
export class LeagueComponent implements OnInit {

  leagues:League[]
  constructor(private leagueService:LeagueService,private _router:Router) { }

  ngOnInit(): void {
    this.leagueService.getAllLeagues().subscribe(
      (leaguesList)=>this.leagues=leaguesList,
      error=>console.log(error),
      ()=>console.log('completed')
    );
  }
  onClick=(league:League)=>{
      this._router.navigate(['/league-details',league.leagueId])
  }

}
