var arr1=[10,20,30,40];
var arr2=[50,60,70,80];
var arr3=[...arr1,50,60,...arr2];
arr3.forEach(val=>console.log(val))

var mobile={model:'A123',brand:'Samsung',price:9000}
var features={os:'Android',ROM:'8GB'}

var newmobile={...mobile,...features}
for(const key in newmobile) {
    const element=newmobile[key];
    console.log(element);
}
var numbers=[98,39,28,63,58];
var maximum=Math.max(...numbers);
console.log(maximum);

var values:string[]|number[]
values=['Ram','Tom','Priya']

var check=(value:string|number|object)=>{
    if(typeof value=='string')
        console.log(value.toUpperCase());
    if(typeof value=='number')
        console.log('multiple of 10: ',value*10);
    if(Array.isArray(value))
        value.forEach(v=>console.log("multiple of 2: "+(v*2)));
    if(typeof value=='object')
        for(const key in value) {
            const element=value[key];
            console.log(element);
        }
}
check('Priya');
check(20);
check({id:10,itemname:'mobile'});
check([1,2,3,4,5]);