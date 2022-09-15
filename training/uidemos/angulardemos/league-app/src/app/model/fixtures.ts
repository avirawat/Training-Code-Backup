import { League } from "./league";
import { Team } from "./team";

export class Fixtures {
  constructor(
    public squads:string,
    public fixturesId:number,
    public stadium:string,
    public league:League,
    public teams:Set<Team>,
    public tournamentImg:string


   ){}

}
