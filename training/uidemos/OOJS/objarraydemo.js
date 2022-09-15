var students=[
    {
        studentName:"Avinash",
        age:'24',
        hobbies:["singing","playing"],
        address:{
            city:"Ayodhya",
            state:"UP",
        },
        mobile:7991237314,
    },
    {
        studentName:"Teja",
        age:'24',
        hobbies:["singing","playing"],
        address:{
            city:"Ayodhya",
            state:"UP",
        },
        mobile:7991237314,
    },
    {
        studentName:"Ayan",
        age:'24',
        hobbies:["singing","playing"],
        address:{
            city:"Ayodhya",
            state:"UP",
        },
        mobile:7991237314,
    }
]
students.forEach(student=> {
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
})
students.forEach(student=>console.log(student));