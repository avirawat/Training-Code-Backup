import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TeamComponent } from './team/team.component';
import { TeamDetailsComponent } from './team-details/team-details.component';
import { LeagueDetailsComponent } from './league-details/league-details.component';
import { LeagueComponent } from './league/league.component';
import { FixturesComponent } from './fixtures/fixtures.component';
import { FixturesDetailsComponent } from './fixtures-details/fixtures-details.component';
import { HomeComponent } from './home/home.component';
import { LiveMatchesComponent } from './live-matches/live-matches.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { PlayerDetailsComponent } from './player-details/player-details.component';
import { SportsComponent } from './sports/sports.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AdminModule } from './admin/admin.module';

@NgModule({
  declarations: [
    AppComponent,
    TeamComponent,
    TeamDetailsComponent,
    LeagueDetailsComponent,
    LeagueComponent,
    FixturesComponent,
    FixturesDetailsComponent,
    HomeComponent,
    LiveMatchesComponent,
    PagenotfoundComponent,
    PlayerDetailsComponent,
    SportsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AdminModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
