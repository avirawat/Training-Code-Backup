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
var Employee = /** @class */ (function () {
    function Employee(name, salary) {
        var _this = this;
        this.name = name;
        this.salary = salary;
        this.printDetails = function () { return console.log(_this.name); };
    }
    return Employee;
}());
var Manager = /** @class */ (function (_super) {
    __extends(Manager, _super);
    function Manager(name, salary) {
        var _this = _super.call(this, name, salary) || this;
        _this.name = name;
        _this.salary = salary;
        _this.calcBonus = function (amount) {
            console.log("Bonus is " + (amount + _this.salary));
        };
        return _this;
    }
    return Manager;
}(Employee));
var manager = new Manager('Raj', 1200);
manager.printDetails();
manager.calcBonus(200);
