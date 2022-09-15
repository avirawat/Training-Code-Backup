//it doses not support overload 
// function greet() {
//     console.log("priya")
// }
// function greet(username) {
//     console.log("avinash");
// }
//greet();

//functin declaration overload functions
//no of para,eter should be same,datatype and return type should be diff

function add(n1:number,n2:number):number;
function add(n1:string,n2:string):string;

//function implemenmtation

function add(n1:any,n2:any):any{
    return n1+n2;
}
console.log(add(10,20));
console.log(add("helo ","avi"));
