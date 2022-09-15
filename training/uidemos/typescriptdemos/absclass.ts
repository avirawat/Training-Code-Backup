abstract class Employee {
    constructor(public name:string,public salary:number){}
    abstract calcBonus(amount:number):void
    printDetails=()=>console.log(this.name);
}
class Manager extends Employee{
    constructor(public name:string,public salary:number){
        super(name,salary);
    }
    calcBonus=(amount:number):void=> {
        console.log("Bonus is "+(amount+this.salary));
    }

}
let manager=new Manager('Raj',1200);
manager.printDetails();
manager.calcBonus(200);