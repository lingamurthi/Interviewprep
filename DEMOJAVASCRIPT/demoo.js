 let s1="hi     bye"



 let s2=s1.split(" ").filter((s)=>{return (s!=="")}).reverse()


console.log(s2);

let x=NaN

console.log(typeof x);



function m()
{
    let j=99

    
     function n()
    {
     console.log("HIIIIII" +j);
    }
    n()
   
}
m()








// let s3="";

// for(let i of s2)
// {
//     s3+=i+" "
// }

// console.log(s3);



// let s1="hi     bye"

// console.log(s1.split(" "));
// let s2=""
// for(let i of s1.split(" "))
// {

//  //   console.log(i.split("").reverse().filter((s)=>{return s!=""}));
// s2+=i.split("").filter((s)=>{return s!=""}).reverse().join("") +" "  
// }
// console.log(s2);
// console.log(s1.split("").reverse().join(""));