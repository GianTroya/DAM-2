const http = require('http');
http.createServer(function (req, res) {
res.writeHead(200, {'Content-Type': 'text/plain'});
res.end('Hello, World!\n');
}).listen(8124, '127.0.0.1');
console.log('Server running at http://127.0.0.1:8124');
// a diferencia del otro (ls) este script no termina su ejecución, 
//ya que tenemos un event listener (hay que cerrar con ctr +c)
// se puede ejecutar con node app o con node app.js
