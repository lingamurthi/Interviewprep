var string = "Welcome to this Javascript Guide!";

console.log(string.split("").reverse().join(""))

console.log(string.split(" ").reverse().join(" "));
















var string = "Welcome to this Javascript Guide!";

// Output becomes !ediuG tpircsavaJ siht ot emocleW
var reverseEntireSentence = reverseBySeparator(string, "");
console.log(reverseEntireSentence);

// Output becomes emocleW ot siht tpircsavaJ !ediuG
var reverseEachWord = reverseBySeparator(reverseEntireSentence, " ");

function reverseBySeparator(string, separator) {
  return string.split(separator).reverse().join(separator);
}


console.log(reverseEachWord);







// let text = "space    is    short  but      tab   is  long"
// let arr = text.split(" ").filter(x => x !== "")

// let arr2 = text.split(" ")
// console.log(arr2);
// console.log(arr);
// let finalText = "";

// for (let item of arr) {
//   finalText += item + " "
// }

console.log(finalText)