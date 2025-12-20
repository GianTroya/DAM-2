var count = 0;
exports.next = function() { return ++count; };
exports.hello = function() {
return "Hello, world!";
};

// alcance de las variables y funciones. Solamente lo que se xporta
// node
// > const t=require('./04simple');
// undefined
// > t.hello();
// 'Hello, world!'
// > t.next();
// 1
// > t.next();
// 2
// > console.log(t.count);
// undefined
// undefined
// >