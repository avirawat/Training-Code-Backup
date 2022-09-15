//function return an oject
var greet=function(){
    var username='Avinash';
    return {
       name:'priya',city:'Banglaore',details:function(){}
    }
}
var userobj=greet();
console.log(userobj);

//module
(function(uname){
    console.log( `welcome`,uname);
})("priya")

//function
 var incalc=function() {
     //private member
     var year=5;var rate=2;
    var interest;
    var message='Interset Calculation';
    return {
        setInterest:function(amount){
            interest=amount*year*rate;
        },
        getInterest:function(){
            return interest;
        },
        newmessage:message
    }
 };
 var myobj=incalc(8000);
 myobj.setInterest(8000);
 console.log(myobj.getInterest());
 console.log(myobj.newmessage);

 //module
 var interestModule=(function(amount) {
    //private member
    var year=5;var rate=2;
   var interest;
   var message='Interset Calculation';
   return {
       setInterest:function(){
           interest=amount*year*rate;
       },
       getInterest:function(){
           interestModule.setInterest(amount);
           return interest;
       },
       newmessage:message
   }
})(8000);
var finalInterest=interestModule.getInterest();
console.log(finalInterest);
console.log(interestModule.newmessage);



//module
var inModule=(function(amount) {
    //private member
    var _year=5;var _rate=2;
   var interest;
   var message='Interset Calculation';

   var _setInterest=function(){
    interest=amount*_year*_rate;
   }
   var _getInterest=function(){
        _setInterest();
        return interest;
   }
   return {
       
       intAmount:_getInterest(),
        newmessage:message
   }

})(8000);
 var final=inModule.intAmount;
 console.log(final);
