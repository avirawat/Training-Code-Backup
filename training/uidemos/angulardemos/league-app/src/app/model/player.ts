import { Team } from "./team";

export class Player {
  constructor(
    public playerId:number,
    public playerName:string,
    public team:Team,
    public playerImg:string
){}
}
