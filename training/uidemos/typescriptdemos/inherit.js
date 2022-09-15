var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Employ = /** @class */ (function () {
    function Employ(name, city) {
        this.name = name;
        this.city = city;
        this.print = function () {
            console.log('welcome');
        };
    }
    return Employ;
}());
var Manager = /** @class */ (function (_super) {
    __extends(Manager, _super);
    function Manager(name, city, salary) {
        var _this = _super.call(this, name, city) || this;
        _this.name = name;
        _this.city = city;
        _this.salary = salary;
        _this.print = function () {
            console.log('Hello');
        };
        return _this;
    }
    Manager.prototype.show = function (msg) {
        console.log('Hello ', msg);
    };
    return Manager;
}(Employ));
var emp = new Manager('Ram', 'Bangalore', 1000);
emp.print();
console.log(emp instanceof Employ);
console.log(emp instanceof Manager);
var mgr = new Manager('Rohan', 'Bangalore', 1000);
mgr.print();
mgr.show('Have a good day');
