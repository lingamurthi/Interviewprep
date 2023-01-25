// let s="welcome to geeksforgeeks"


//   let s1= s.replace(/[aeiou]/gi,"")


// console.log(s1);
// s=s1
// console.log(s);

// if(s===s1)
// {
//     console.log("true");
// }


//segeregate os and 1s
// let array1=[0, 1, 0, 1, 0, 0, 1, 1, 1, 0] 
// let i=0 
// let j=array1.length-1
// let temp

// while(i<j)
// {
// if(array1[i]!=1 && array1[j]!=0)
// {
//     i++
//     j--
   

// }
// else{
//     temp=array1[i]
//     array1[i] =array1[j]
//     array1[j] =temp
// }
// if(array1[i]!=0 && array1[i]==array1[j])
// {

//     j--
   

// }
// if(array1[j]!=1 && array1[i]==array1[j])
// {

//     i++
   

// }

// }

// let cont=1
// for(let t of array1)
// {
//     console.log("count"+t+cont++);
// }







let array1=[3,5,7,2,4,6] 
let i=0 
let j=array1.length-1
let temp

while(i<j)
{
if(array1[i]%2==0 && array1[j]%2==1)
{
    i++
    j--
   

}
else{
    temp=array1[i]
    array1[i] =array1[j]
    array1[j] =temp

    i++
    j--
}
if(array1[i]%2==0 && array1[j]%2==0)
{

    i++
   

}
if(array1[i]%2==1 && array1[j]%2==1)
{

    j--
   

}

}


for(let t of array1)
{
    console.log(t);
}