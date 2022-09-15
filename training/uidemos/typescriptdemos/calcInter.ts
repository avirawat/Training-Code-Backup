interface Calculator{
    add:(x:number,y:number)=>void;
    sub:(x:number,y:number)=>void;

}
interface SciCalculator extends Calculator{
    square:(x:number)=>void
}
class BasicCalc implements Calculator{
    add= (x:number,y:number)=> console.log(x+y);
    sub= (x:number,y:number)=> console.log(x-y);
    
}
class SciCalc extends BasicCalc implements SciCalculator {
    square=(x:number)=>console.log(x*x);
}
function basicOperations(calc:Calculator,x:number,y:number){
    calc.add(x,y);
    calc.sub(x,y);
}
let calcultor:Calculator=new BasicCalc();
basicOperations(calcultor,20,10);
function performOperation(calc:SciCalculator,x:number,y:number) {
    calc.square(x);
    calc.add(x,y);
}
let scicalculator:SciCalculator=new SciCalc();
performOperation(scicalculator,300,2);
performOperation(new SciCalc(),300,2);