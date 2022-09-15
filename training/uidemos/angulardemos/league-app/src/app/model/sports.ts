import { League } from "./league";

export class Sports{
  constructor(
    public name:string,
    public sportsId:number,
    public origin:string,
  public sportsImg:string,
    public leagues?:Set<League>

   ){}

}
