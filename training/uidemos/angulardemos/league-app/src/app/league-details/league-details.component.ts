import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { League } from '../model/league';
import { LeagueService } from '../services/league.service';

@Component({
  selector: 'ics-league-details',
  templateUrl: './league-details.component.html',
  styleUrls: ['./league-details.component.css']
})
export class LeagueDetailsComponent implements OnInit {

  leagueId: number;
  league: League;
  constructor(
    private _leagueService: LeagueService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      (map)=>{
        this.leagueId = parseInt(map.get("id"));
      });
    this._leagueService.getById(this.leagueId).subscribe(
      nleague=>{
        this.league=nleague,
        console.log(this.league);
      },
      error=>console.log(error),
      ()=>console.log("completed")

    )
  }

}
