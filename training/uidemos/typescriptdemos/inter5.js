var MobileImpl = /** @class */ (function () {
    function MobileImpl() {
        this.call = function () { return console.log('calling...........'); };
    }
    MobileImpl.prototype.charging = function () {
        console.log('charging........');
    };
    return MobileImpl;
}());
function gadgetsDetails() {
    return {
        charging: function () { return console.log('charging'); },
        call: function () { return console.log('calling...........'); },
        work: function () { return console.log("working"); }
    };
}
var newGadegts = gadgetsDetails();
//newGadegts.call();
newGadegts.charging();
//newGadegts.work();
var mob = gadgetsDetails();
mob.call();
mob.charging();
mob.work();
