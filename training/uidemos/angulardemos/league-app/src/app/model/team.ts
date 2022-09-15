import { Player } from "./player";

export class Team {
  constructor(
    public teamId:number,
    public teamName:string,
    public owner:string,
    public players:Set<Player>,
    public teamImg:string


   ){}

}
