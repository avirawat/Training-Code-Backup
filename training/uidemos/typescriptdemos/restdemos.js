function findSum() {
    var numbers = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        numbers[_i] = arguments[_i];
    }
    var sum = 0;
    numbers.forEach(function (num) { return sum += num; });
    console.log("Sum ", sum);
}
findSum(90, 80, 70);
findSum(1, 2, 3, 4, 5);
