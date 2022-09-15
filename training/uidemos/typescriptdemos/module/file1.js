"use strict";
exports.__esModule = true;
exports.Product = exports.greet = exports.greeting = void 0;
exports.greeting = 'Helo world';
function greet() {
    anyMethod();
    console.log('exported');
}
exports.greet = greet;
//similiar to private
function anyMethod() {
    console.log('cpnfidential -not exported');
}
var Product = /** @class */ (function () {
    function Product(itemName, price) {
        var _this = this;
        this.itemName = itemName;
        this.price = price;
        this.getinfo = function () {
            console.log(_this.itemName + " is of price " + _this.price);
        };
    }
    return Product;
}());
exports.Product = Product;
