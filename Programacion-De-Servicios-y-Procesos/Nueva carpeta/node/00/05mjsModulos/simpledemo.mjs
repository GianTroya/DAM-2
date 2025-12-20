import * as simple2 from './simple2.mjs';
console.log(simple2.hello());
console.log(`${simple2.next()} ${simple2.squared()}`);
console.log(`${simple2.next()} ${simple2.squared()}`);
console.log(`${simple2.default()} ${simple2.squared()}`);
console.log(`${simple2.next()} ${simple2.squared()}`);
console.log(`${simple2.next()} ${simple2.squared()}`);
console.log(`${simple2.next()} ${simple2.squared()}`);
console.log(simple2.meaning);


// node --experimental-modules simpledemo.mjs
// Hello, world!
// 1 1
// 2 4
// 2 4
// 3 9
// 416
// 525
// 42