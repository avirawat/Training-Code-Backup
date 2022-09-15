export class Course {
  constructor(
    public courseId:number,
    public courseName:string,
    public cost:number,
    public courseType:string,
    public trainer?:string
  ){}
}
