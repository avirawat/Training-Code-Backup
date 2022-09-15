// interface extending class
// methods will come as abstract
class Vehicle{
    constructor(public brand:string,public model:string){}
    getBrand= ():string=>{
        return this.brand;
    }
}
class Accessories{
    constructor(public acc1:string,public acc2:string){}
    getAccessories = ():void=>{
        console.log(this.acc1,this.acc2);
    }
}
// when an interface extends a class, the methods become abstract
interface IDetails extends Vehicle,Accessories{
    getMileage: () =>void;
}
// this clss should all methods and should have const from both classes
class Car implements IDetails{
    constructor(public brand:string,public model:string,public acc1:string,public acc2:string){}
    getMileage= () =>{
        console.log("mileage");
    }
    getBrand= () => {
        return 'car brand'};
    getAccessories= () =>{
        console.log("accessories for car class ",this.acc1);
     };
  
    
}
let car:IDetails=new Car('br','mod','AC','Music');
car.getAccessories();
console.log(car.getBrand());
car.getMileage();
