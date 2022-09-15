import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fixtures } from '../model/fixtures';
import { FixtureService } from '../services/fixtures.service';

@Component({
  selector: 'ics-fixtures',
  templateUrl: './fixtures.component.html',
  styleUrls: ['./fixtures.component.css']
})
export class FixturesComponent implements OnInit {

  fixtures:Fixtures[]
  constructor(private fixtureService:FixtureService,private _router:Router) { }

  ngOnInit(): void {
    this.fixtureService.getAllFixtures().subscribe(
      fixturesList=>this.fixtures=fixturesList,
      error=>console.log(error),
      ()=>console.log('completed')
    )
  }
  onClick=(fixtures:Fixtures)=>{
    this._router.navigate(['/fixtures-details',fixtures.fixturesId])
}

}
