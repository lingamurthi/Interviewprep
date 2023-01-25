// let a=[]



// let obj={
//     firstname: 'John',
//     lastname: 'Smith'
// }


// let obj2={
//     home: 'sssss' 
// }


// //obj=obj2


// let full=function(hometown){
//     console.log(this.firstname + ' ' + this.lastname + ' '+ hometown); 
// }


// full.call(obj,"delhi")


// let fun=full.bind(obj,"delhi")

// fun()









// //bind polyfill
// Function.prototype.mybind=function(...args)
// {
//     let obj=this 
//     return function ()
//     {
//         obj.call(args[0],args[1])
//     }
// }


// let m=full.mybind(obj,"delhi")
// m()








let obj={
    firstname: 'John',
    lastname: 'Smith'
}


let full=function(hometown1,hometown2,country){
    console.log(this.firstname + ' ' + this.lastname + ' '+ hometown1 + ' ' +hometown2 + ' ' + country); 
}


//bind polyfill

Function.prototype.mybind=function(...args)
{
    let obj=this 

    slicing=args.slice(1)
  return function(...args2)
  {

    console.log(...args2);
    obj.apply(args[0],[...slicing,...args2])
  }
}


let m=full.mybind(obj,"delhi","bng")
m("India")




