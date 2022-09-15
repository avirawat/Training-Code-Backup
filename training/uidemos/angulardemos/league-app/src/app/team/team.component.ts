import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Team } from '../model/team';
import { TeamService } from '../services/team.service';

@Component({
  selector: 'ics-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

teams:Team[]
  constructor(private teamService:TeamService, private router:Router) { }

  ngOnInit(): void {
    this.teamService.getAllTeams().subscribe(
      teamsList => this.teams=teamsList,
      error =>console.log(error),
      ()=>console.log('completed')
    )
  }
  onClick = (team:Team)=>{
    this.router.navigate(['/team-details',team.teamId])
  }
}

