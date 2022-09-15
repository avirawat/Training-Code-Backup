interface Mobile {
    charging():void;
   // call():void;
}
interface Laptop {
    charging():void;
    call():void;
    work():void;
}
class MobileImpl implements Mobile{
    charging(){
console.log('charging........');
    }
    call=()=>console.log('calling...........');
}
function gadgetsDetails():Mobile|Laptop {
    return {
        charging:()=>console.log('charging'),
        call:()=>console.log('calling...........'),
        work:()=>console.log("working..........")
    }
}

let newGadegts=gadgetsDetails();
//newGadegts.call();
newGadegts.charging();
//newGadegts.work();

let mob:any=gadgetsDetails();
mob.call();
mob.charging();
mob.work();