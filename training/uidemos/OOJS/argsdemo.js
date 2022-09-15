//var args
var calcSum=function() {
    var sum=0;
    for(let index=0;index<arguments.length;index++) {
        sum+=arguments[index];
    }
    console.log(sum);
}
calcSum(10,20);
calcSum(10,20,30);
calcSum(10,20,30,40);

//rest paarameter

var calcSum=function(...nums) {
    var sum=0;
    nums.forEach(value=>sum+=value)
    // for(let index=0;index<arguments.length;index++) {
    //     sum+=arguments[index];
    // }
    console.log(sum);
}
calcSum(10,20);
calcSum(10,20,30);
calcSum(10,20,30,40);

