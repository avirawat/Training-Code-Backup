import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './admin/login/login.component';
import { FixturesDetailsComponent } from './fixtures-details/fixtures-details.component';
import { FixturesComponent } from './fixtures/fixtures.component';
import { HomeComponent } from './home/home.component';
import { LeagueDetailsComponent } from './league-details/league-details.component';
import { LeagueComponent } from './league/league.component';
import { LiveMatchesComponent } from './live-matches/live-matches.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { PlayerDetailsComponent } from './player-details/player-details.component';
import { SportsComponent } from './sports/sports.component';
import { TeamDetailsComponent } from './team-details/team-details.component';
import { TeamComponent } from './team/team.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'leagues',component:LeagueComponent},
  {path:'sports',component:SportsComponent},
  {path:'teams',component:TeamComponent},
  {path:'league-details/:id',component:LeagueDetailsComponent},
  {path:'team-details/:id',component:TeamDetailsComponent},
  {path:'fixtures',component:FixturesComponent},
  {path:'fixtures-details/:id',component:FixturesDetailsComponent},
  {path:'player-details/:id',component:PlayerDetailsComponent},
  {path:'live-match',component:LiveMatchesComponent},
  {path:'player-details/:id',component:PlayerDetailsComponent},
  {path:'admin',component:LoginComponent},
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'**',component:PagenotfoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
