import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Team } from '../model/team';
import { TeamService } from '../services/team.service';

@Component({
  selector: 'ics-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.css']
})
export class TeamDetailsComponent implements OnInit {

teamId:number;
  team:Team;
  constructor(private teamService:TeamService, private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      map=>{
        this.teamId = parseInt(map.get("id"))
      });
      this.teamService.getById(this.teamId).subscribe(
        nteam=>this.team=nteam,
        error=>console.log(error),
        ()=>console.log("completed")
       )
      }
    }

