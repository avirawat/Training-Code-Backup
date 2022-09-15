var User=function(name,city){
    this.name=name;
    this.city=city;
}
var Employee=function(name) {
    this.name=name;
}
var greet=function(message,message1) {
    console.log(message+ this.name);
    console.log(message1)
}
var user=new User("Joe","TVL");
greet.call(user,'Hav a great day','Hello');
greet.apply(user,['HI','Hello']); //paasing arggument as array

var emp=new Employee('Khanna');
greet.call(emp,'Have a greta day','hello');
greet.apply(emp,['hi','Hello']);

var product=function(productname,price) {
    this.productname=productname;
    this.price=price;
}
var laptop=function(model,price) {
    this.model=model;
    this.price=price;
}
var discountedprice=function(amount) {
    console.log('price ' + (this.price-amount))
}
var productVal=new product("mobile",12000);
discountedprice.call(productVal,100);
discountedprice.apply(productVal,[500]);

// var access=function("samsung",14000) {
//     discountedprice.call(access,'this is discounted price');
//     discountedprice.apply(access,['discounted price'])
// }
