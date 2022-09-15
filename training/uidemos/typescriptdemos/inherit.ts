class Employ{
    constructor(public name:string,public  city:string){}
    print = ()=>{
        console.log('welcome');
    }
}
class Manager extends Employ{
    constructor(public name:string,public city:string,public salary:number){
        super(name,city)
        
    }
    print = ()=>{
        console.log('Hello');
    }
    show(msg:string){
        console.log('Hello ',msg);

    }
}
const emp: Employ = new Manager('Ram','Bangalore',1000);
emp.print();
console.log(emp instanceof Employ)
console.log(emp instanceof Manager)
const mgr: Manager = new Manager('Rohan','Bangalore',1000);
mgr.print();
mgr.show('Have a good day');
