import { Board } from "./board";
import { Fixtures } from "./fixtures";
import { Sports } from "./sports";


export class League {
  constructor(
    public name:string,
    public leagueId:number,
    public country:string,
    public durationInMonths:number,
    public board:Board,
    public imagepath:string,
    public fixtures:Set<Fixtures>,
    public sports:Sports


   ){}

}
