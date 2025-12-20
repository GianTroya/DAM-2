const fs = require('fs');
// fs es parte de node.js core (filesystem)
const util = require('util');
const fs_readdir = util.promisify(fs.readdir);
(async () => {
const files = await fs_readdir('.');
for (let fn of files) {
console.log(fn);
}
})().catch(err => { console.error(err); });
// npm install -g hexy
// es una dependencia que nos permite ver el código en hexadecimal con
//  hexy --width 12 ls.js