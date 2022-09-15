var student={
    studentName:"Avinash",
    age:'27',
    hobbies:["singing","playing"],
    address:{
        city:"Ayodhya",
        state:"UP",
        mobile:7991237314,
    }
}
//console.log(student.studentName)
//console.log(student[studentName])
//console.log(student.address.city)

console.log(typeof(student.hobbies));
for (const key in student) {
    var stud=student[key];
    if(Array.isArray(stud)){
        for(const key in stud)
        console.log("HObby", stud[key]);
    }
    else if(typeof(stud)=="object"){
        for(const key in stud)
            console.log(key, stud[key]);
    } else
        console.log(key, student[key]);
}

