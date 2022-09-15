import { Status } from "./status.enum";

export class Worker {
  constructor(
    public workerName:string,
    public workerId:number,
    public availability:string,
    public contactNumber:string,
    public workType:string,
    public workingHours:number,
    public workerImg:string
){}

}
