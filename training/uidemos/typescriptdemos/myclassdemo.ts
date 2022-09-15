class Student {
    constructor(public studentName:string,
        public studentId:number,
        public department?:string,
        public city:string='Banglore'){}
        
printDetails=()=>{
    console.log(this.studentName);
    console.log(this.city);
    console.log(this.studentId);
    console.log(this.department);
}
showHobbies=(...hobbies:string[]):void=> {
    hobbies.forEach(hobby=>console.log(hobby));
}
}
var student=new Student('Ram',10);
student.printDetails();
student.showHobbies('sports','music');

var student=new Student('Ram',10,'CSE','Hyd');
student.printDetails();
student.showHobbies('sports','music','dance');