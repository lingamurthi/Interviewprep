// Debouncing in Javascript
let counter = 0;
const getData = () => {
  // calls an API and gets Data
  console.log("Fetching Data ..", counter++);
}

const debounce = function (fn, d) {
  let timer;

  let flag=true

  return function(){
    let context = this
    let args = arguments;
if(flag)
{
    fn.apply(context, args)
    flag=false
    timer = setTimeout(() =>{
        flag=true
        
    }, d)
}
    
}
}
const betterFunction = debounce(getData, 1000);