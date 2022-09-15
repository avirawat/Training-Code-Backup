interface Shaper{ 
    //variables
    x:number;
    y:number;
    z?:number; //optional
    printArea():void;

}
class Rectangle implements Shaper {
    constructor(public x:number,
                public y:number){}

                printArea=()=>console.log("From class "+(this.x*this.y));
}
function showArea(shape:Shaper):void {
    console.log('show the area details ')
    shape.printArea();
}
let rect=new Rectangle(20,20);
showArea(rect);
showArea(new Rectangle(10,20));

var rectLiteral={
    x:10,
    y:20,
    printArea:function() {
        console.log('From literal Area '+(this.x*this.y))
    }
}
showArea(rectLiteral);
showArea({
    x:100,
    y:200,
    printArea:function() {
        console.log('Object Area '+(this.x*this.y))
    }
})

