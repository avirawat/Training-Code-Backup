"use strict";
exports.__esModule = true;
//import individual elements
var file1_1 = require("./file1");
console.log(file1_1.greeting);
(0, file1_1.greet)();
var prod = new file1_1.Product('Pen', 10);
prod.getinfo();
//importing the modeule as whole
var mymodule = require("./file1");
console.log(mymodule.greeting);
console.log(mymodule.greet());
// given as alias name
var prod = new file1_1.Product('Marker', 10);
console.log(prod.getinfo());
