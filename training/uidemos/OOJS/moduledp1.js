//module design pattern
var cartModule=(function(){
    var cart=[];

    //refers to private members
    var _addToCart=function(item){
        cart.push(item);
        console.log("item added");
    }
    var _itemcount=function() {
        return cart.length;
    }

    var _message=function() {
        return "Happy Shopping";
    }

    var _totalAmount=function() {
        var sum=0;
        cart.forEach(cartItem=>{
            sum+=cartItem.price;
        })
        return sum;
    }

    return {
        message:"cart Details",
        addToCart:_addToCart,  //property();
        getTotalCount:_itemcount,   //property()
        getTotalPrice:_totalAmount,
        shopMessage:_message(),
        showCart:function() {
            cart.forEach(cartItem=>console.log(cartItem.name));
        }

    }
})();
cartModule.addToCart({
    name:'bread',price:30
})
cartModule.addToCart({
    name:'butter',price:150
})
 var items = cartModule.getTotalCount();
 console.log('total items ',items);
 var amount = cartModule.getTotalPrice();
 console.log("Amount : "+amount);
console.log('Total Items in cart ')
cartModule.showCart();
console.log(cartModule.shopMessage);



