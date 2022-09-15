var Rectangle = /** @class */ (function () {
    function Rectangle(x, y) {
        var _this = this;
        this.x = x;
        this.y = y;
        this.printArea = function () { return console.log("From class " + (_this.x * _this.y)); };
    }
    return Rectangle;
}());
function showArea(shape) {
    console.log('show the area details ');
    shape.printArea();
}
var rect = new Rectangle(20, 20);
showArea(rect);
showArea(new Rectangle(10, 20));
var rectLiteral = {
    x: 10,
    y: 20,
    printArea: function () {
        console.log('From literal Area ' + (this.x * this.y));
    }
};
showArea(rectLiteral);
showArea({
    x: 100,
    y: 200,
    printArea: function () {
        console.log('Object Area ' + (this.x * this.y));
    }
});
