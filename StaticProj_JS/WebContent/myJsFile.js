/** keep fn def in HEAD tag while fn-calls at end of body..
 * no 'var' = global scope
 * var = fun scope (not just block)
 * let = scope is within a block
 * const = cannot change
 */
const anArray = ['My String', 12, true];
let aString = `Back-tick interpolation of variables is ${anArray[anArray.length-1]}`;

document.writeln(aString);
anArray.push('a 2nd str');
aString = `<br> Back-tick interpolation of variables is ${anArray[anArray.length-1]}`;
document.writeln(aString);
for(let i=0;i<3;i++){document.writeln(`<br> ${anArray[i]}`);}

var x = "debug with alert & console";
//alert(x);
console.log(x);