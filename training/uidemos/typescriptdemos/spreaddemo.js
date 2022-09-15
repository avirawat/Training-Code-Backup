var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var __spreadArray = (this && this.__spreadArray) || function (to, from, pack) {
    if (pack || arguments.length === 2) for (var i = 0, l = from.length, ar; i < l; i++) {
        if (ar || !(i in from)) {
            if (!ar) ar = Array.prototype.slice.call(from, 0, i);
            ar[i] = from[i];
        }
    }
    return to.concat(ar || Array.prototype.slice.call(from));
};
var arr1 = [10, 20, 30, 40];
var arr2 = [50, 60, 70, 80];
var arr3 = __spreadArray(__spreadArray(__spreadArray([], arr1, true), [50, 60], false), arr2, true);
arr3.forEach(function (val) { return console.log(val); });
var mobile = { model: 'A123', brand: 'Samsung', price: 9000 };
var features = { os: 'Android', ROM: '8GB' };
var newmobile = __assign(__assign({}, mobile), features);
for (var key in newmobile) {
    var element = newmobile[key];
    console.log(element);
}
var numbers = [98, 39, 28, 63, 58];
var maximum = Math.max.apply(Math, numbers);
console.log(maximum);
var values;
values = ['Ram', 'Tom', 'Priya'];
var check = function (value) {
    if (typeof value == 'string')
        console.log(value.toUpperCase());
    if (typeof value == 'number')
        console.log('multiple of 10: ', value * 10);
    if (Array.isArray(value))
        value.forEach(function (v) { return console.log("multiple of 2: " + (v * 2)); });
    if (typeof value == 'object')
        for (var key in value) {
            var element = value[key];
            console.log(element);
        }
};
check('Priya');
check(20);
check({ id: 10, itemname: 'mobile' });
check([1, 2, 3, 4, 5]);
