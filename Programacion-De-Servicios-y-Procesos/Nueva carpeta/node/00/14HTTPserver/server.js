//ahora si es posible entender esto algo mejos
const http = require('http');
const server = http.createServer();
//.createServer() es una función que crea un evenEmmiter
//debajo lo consumimos con el .on()
server.on('request', (req, res) => {
res.writeHead(200, {'Content-Type': 'text/plain'});
res.end('Hello, World!\n');
});
//.listen() hace que el servidos comiense a atender
// y no se detenga
server.listen(8124, '127.0.0.1');
console.log('Server running at http://127.0.0.1:8124');