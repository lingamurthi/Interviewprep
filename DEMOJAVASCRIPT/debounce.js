// Debouncing in Javascript
let counter = 0;
const getData = () => {
  // calls an API and gets Data
  console.log("Fetching Data ..", counter++);
}

const debounce = function (fn, d) {
  let timer;
  

  return function(){
    let context = this
    let args = arguments;

    console.log("this" +this +"args" + args);
 
    clearTimeout(timer);
    timer = setTimeout(() => fn.apply(context, args), d)
}
}
const betterFunction = debounce(getData, 300);