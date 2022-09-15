var names=[1,2,3,4,5,6]
for(let index=0;index<names.length;index++) {
    const element=names[index];
    console.log(element);
}
//similar to for each
for(const uname of names) {
    console.log(uname)
}
//key is the index
for(const key in names) {
    console.log(names[key]);
}
names.forEach(function(value,index,names){
    console.log('value',value);
    console.log('index',index);
    console.log('val',names[index]);
})

names.forEach((value,index)=>console.log(value+" "+index));