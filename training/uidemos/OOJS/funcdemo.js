greet();
//finction decalation

function greet() {
    console.log("welcome");
}
//function expresison
var message = function(){
    console.log("Great day");
}
message();
//funbction expression with return type
var sayHello=function(username) {
    return "GoodDay"+username;
}
console.log(sayHello('Rahul'));

var fun1=function(func,username) {
    console.log(func(username));
}
fun1(sayHello,'Avi');

// imedietly invoke function
(function(){
    console.log('welcome');
})();

(function(username){
    console.log('welcome',username);
})('Avi');