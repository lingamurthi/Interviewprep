s1="listen"
s2="silent"

let a=[]
a=s1.split("")
a.sort()
console.log(a);


let b=[]
b=s2.split("")
b.sort()
console.log(b);
console.log(JSON.stringify(a));

if(JSON.stringify(a)==JSON.stringify(b))
{
    console.log("true");
}