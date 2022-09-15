//import individual elements
import { greeting,Product,greet } from "./file1";
console.log(greeting);
greet();
var prod:Product=new Product('Pen',10);
prod.getinfo();

//importing the modeule as whole
import * as mymodule from './file1'
console.log(mymodule.greeting);
console.log(mymodule.greet());

// given as alias name
var prod=new Product('Marker',50);
console.log(prod.getinfo()); 