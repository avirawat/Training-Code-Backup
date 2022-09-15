import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Fixtures } from '../model/fixtures';
import { FixtureService } from '../services/fixtures.service';

@Component({
  selector: 'ics-fixtures-details',
  templateUrl: './fixtures-details.component.html',
  styleUrls: ['./fixtures-details.component.css']
})
export class FixturesDetailsComponent implements OnInit {
  fixtureId:number
  fixtures:Fixtures
    constructor(private fixtueService:FixtureService,private activatedRoute:ActivatedRoute) { }

    ngOnInit(): void {
      this.activatedRoute.paramMap.subscribe(
        (map)=>{
           this.fixtureId=parseInt(map.get("id"));
        }
      )
      this.fixtueService.getById(this.fixtureId).subscribe(

        fixture=>{

          this.fixtures=fixture
          console.log(this.fixtures); },
        error=>console.log(error),
        ()=>console.log('completed')
      )
    }

}
