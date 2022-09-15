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
var BasicCalc = /** @class */ (function () {
    function BasicCalc() {
        this.add = function (x, y) { return console.log(x + y); };
        this.sub = function (x, y) { return console.log(x - y); };
    }
    return BasicCalc;
}());
var SciCalc = /** @class */ (function (_super) {
    __extends(SciCalc, _super);
    function SciCalc() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.square = function (x) { return console.log(x * x); };
        return _this;
    }
    return SciCalc;
}(BasicCalc));
function basicOperations(calc, x, y) {
    calc.add(x, y);
    calc.sub(x, y);
}
var calcultor = new BasicCalc();
basicOperations(calcultor, 20, 10);
function performOperation(calc, x, y) {
    calc.square(x);
    calc.add(x, y);
}
var scicalculator = new SciCalc();
performOperation(scicalculator, 300, 2);
performOperation(new SciCalc(), 300, 2);
