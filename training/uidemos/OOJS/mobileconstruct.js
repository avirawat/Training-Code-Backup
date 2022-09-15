var Mobile=function(brand,model,price) {
    this.brand=brand;
    this.model=model;
    this.price=price;
    this.show=function() {
        console.log(`Brand ${brand} Model ${model} Price ${price}`);

    }
    

}
var mobile1=new Mobile("samsung","galaxy",15000);
    console.log(mobile1.brand);
    console.log(mobile1.model);
    console.log(mobile1.price);
    mobile1.show();

Mobile.prototype.OS="coloros";
Mobile.prototype.features=function() {
    console.log("Valuable....")
}
Mobile.prototype.getDiscount=function(discount) {
    console.log(discount);
}
mobile1.getDiscount(200);