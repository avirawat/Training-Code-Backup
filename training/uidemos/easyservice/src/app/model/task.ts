import { Priority } from "./priority.enum";
import { Status } from "./status.enum";

export class Task {
  constructor(
    public taskName:string,
    public taskId:number,
    public organiser:string,
    public tStartDate:string,
    public tEndDate:string,
    public durationDays:number,
    public tStatus:Status,
    public tPriority:Priority,
    public maintenance_id:number,
    public taskImg:string,
    public worker_id:number
        ){}
}
