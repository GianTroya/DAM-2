const util = require('util');
const A = "a different value A";
const B = "a different value B";
const m1 = require('./module1');
//* 
// ./ busca en el mismo directorio
// ../ busca en parent
//

console.log(`A=${A} B=${B} values=${util.inspect(m1.values())}`);
// esta siguiente de undefined, 
// porque los valores no se han exportado
// accedemos solo por la función
console.log(`${m1.A} ${m1.B}`);
//guardo los valores del modulo1 en vals
const vals = m1.values();
//puedo cambiar localmente los valores
// a través de la var local
vals.B = "something completely different";
console.log(util.inspect(vals));
//pero en m1.values tendré siempr lo del módulo 
console.log(util.inspect(m1.values()));

// node module2
// A=a different value A B=a different value B values={ A: 'value A', B: 'value B' }
// undefined undefined
// { A: 'value A', B: 'something completely different' }
// { A: 'value A', B: 'value B' }