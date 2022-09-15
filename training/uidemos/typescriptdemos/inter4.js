// interface extending class
// methods will come as abstract
var Vehicle = /** @class */ (function () {
    function Vehicle(brand, model) {
        var _this = this;
        this.brand = brand;
        this.model = model;
        this.getBrand = function () {
            return _this.brand;
        };
    }
    return Vehicle;
}());
var Accessories = /** @class */ (function () {
    function Accessories(acc1, acc2) {
        var _this = this;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.getAccessories = function () {
            console.log(_this.acc1, _this.acc2);
        };
    }
    return Accessories;
}());
// this clss should all methods and should have const from both classes
var Car = /** @class */ (function () {
    function Car(brand, model, acc1, acc2) {
        var _this = this;
        this.brand = brand;
        this.model = model;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.getMileage = function () {
            console.log("mileage");
        };
        this.getBrand = function () {
            return 'car brand';
        };
        this.getAccessories = function () {
            console.log("accessories for car class ", _this.acc1);
        };
    }
    return Car;
}());
var car = new Car('br', 'mod', 'AC', 'Music');
car.getAccessories();
console.log(car.getBrand());
car.getMileage();
