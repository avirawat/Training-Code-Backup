//class implementing interface
interface Person{
    name:string;
    mobile:number;
    age?:number;
    city :string ;
    printDetails: ()=>void

}
class Employee implements Person{
   constructor(public name:string,
    public mobile:number,
    public city:string,
    public company?:string,
    public age?:number){
               }
   printDetails = ()=>{
    console.log(`${this.name} is from ${this.city}`);
    console.log(`${this.age}`);
   }
}
var employee: Person = new Employee('Raju',1290,'Bangalore','ABC',28);
employee.printDetails();
console.log(employee.mobile);

var emplo: Employee = new Employee('Kumaran',1290,'Bangalore','ABC');
emplo.printDetails();
emplo.city='Chennai';
