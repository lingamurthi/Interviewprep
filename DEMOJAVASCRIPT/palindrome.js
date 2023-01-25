// let s1="level"
// let s2="level"

// let a=[]
// let b=[]

// for(let i=s1.length-1;i>0;i--)
// {
//     a.push(s1[i])
// }


// if(s1==s2)
// {
//     console.log("It is a palindrome");
// }
// else
// {
//     console.log("It is not a palindrome");
// }









let n1=111
let n2=111
let r=0
let sum=0

while(n1>0)
{
r=n1%10
sum=r+sum*10
n1=parseInt(n1/10)

console.log(sum);
}


if(sum==n2)
{
    console.log("It is a palindrome number");
}
