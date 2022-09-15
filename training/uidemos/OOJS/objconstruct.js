var Employee =function(name,city) {
    this.name=name;
    this.city=city;
    //adding methods to the constructor
    this.getDetails=function() {
        console.log(`welcome ${name}, from ${city}`);
    }
}
 var employee=new Employee("Avi","Hyd");
 console.log(employee.name);
 console.log(employee.city);
 employee.getDetails();

 var employee1=new Employee('Rahul',"Bangalore");
 console.log(employee1.name);
 employee1.getDetails();

 //to add new instance variable or methods
 Employee.prototype.department='production';
 Employee.prototype.salary=9000;
 Employee.prototype.calBonus=function(amount){
     console.log("Bonus is " +this.salary*amount);
 }
 employee.calBonus(900);
 console.log(employee);
 console.log(employee.getDetails());

