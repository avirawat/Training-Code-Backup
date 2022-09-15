var Employee = /** @class */ (function () {
    function Employee(name, mobile, city, company, age) {
        var _this = this;
        this.name = name;
        this.mobile = mobile;
        this.city = city;
        this.company = company;
        this.age = age;
        this.printDetails = function () {
            console.log(_this.name + " is from " + _this.city);
            console.log("" + _this.age);
        };
    }
    return Employee;
}());
var employee = new Employee('Raju', 1290, 'Bangalore', 'ABC', 28);
employee.printDetails();
console.log(employee.mobile);
var emplo = new Employee('Kumaran', 1290, 'Bangalore', 'ABC');
emplo.printDetails();
emplo.city = 'Chennai';
