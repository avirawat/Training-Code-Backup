var employees=[{
    name:'Avi',empId:10,salary:9000
},{
    name:'JO',empId:11,salary:12000
},{
    name:'Sri',empId:12,salary:6000
}
]
var details=function(message,amount) {
    console.log(message,this.name)
    console.log('Id',this.empId);
    console.log('Salary',this.salary);
    console.log('Bonus'+(this.salary+amount));
}
employees.forEach(emp=> {
    console.log('Emp details');
    details.apply(emp,['Welcome',300]);// values is static
})
employees.forEach(emp=> {
    console.log('Emp details');
    details.call(emp,'Welcome',300); //value is dynamic
})