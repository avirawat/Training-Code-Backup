function findSum(...numbers:number[]) {
    let sum=0;
    numbers.forEach(num=>sum+=num);
    console.log("Sum ",sum);
}
findSum(90,80,70);
findSum(1,2,3,4,5);