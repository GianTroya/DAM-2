import {
    default as simple, hello, next
    } from './simple2.mjs';
    //identificador con el ./ es que está en la misma ruta
    // usando ../ es que está en el directoruio padre
    // estos son los identificadores relativos
    // absolutos son desde el root, pero no son recomendables
    // existe un identificador de modulos en nivel superior
    // su ruta comuenza por el nombreModulo/ruta/a/Modulo
    // tiene que estar en la carpeta node_modules 
    // e implementa una búsqueda si no lo encuentra
    console.log(hello());
    console.log(next());
    console.log(next());
    console.log(simple());
    console.log(next());
    console.log(next());
    console.log(next());


//     node simpledemo2.mjs
// Hello, world!
// 1
// 2
// 2
// 3
// 4
// 5