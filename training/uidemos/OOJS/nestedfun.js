var average=function(m1,m2,m3) {
    console.log('calculating avg');
    var message="Hello......";
    // innner function can access outer variables
    function sum() {
        console.log(message);
        return m1+m2+m3;
    }
    var avg=sum()/3;
    return avg;
}
console.log("avg "+average(90,90,90));

var newaverage=function(m1,m2,m3) {
    console.log('calculating avg');
    var message="Hello......";
    // IIFE
    var avg=(function () {
        console.log(message)
        return m1+m2+m3;
    })()/3;
    return avg;
}
console.log("avg1 "+average(90,90,90));

var average3=function(m1,m2,m3) {
    console.log('calculating avg');
    var message="Sum is..........";
    return function() {
        console.log(message);
        console.log("avg3 "+(m1+m2+m3)/3);
    }
}
// result is again a function
var result=average3(90,90,90);
result();
average3(90,90,90)();


var average4=function(m1,m2,m3) {
    console.log('calculating avg');
    var message="Sum is..........";
    return function() {
        console.log(message);
        return ("avg4 "+(m1+m2+m3)/3);
    }
}
// result is again a function
var result=average4(90,90,90);
var avg4=result();
console.log(avg4);

var empDetails=function(empname,city,salary) {
    console.log(`welcome ${empname} from ${city}`);
    
    return function(amount) {
        console.log('calculating bonus');
        let bonus=amount*salary;
        return bonus;
    }

}
var details=empDetails("Avi","hys",9000);
var bonus=details(300);
console.log(bonus);

var bonus1=empDetails("AVi","hyd",9000)(300);
console.log(bonus1);