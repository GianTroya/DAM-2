const Pulser = require('./pulser');
// este con mayúsculas

// instanciamos un objeto Pulser
const pulser = new Pulser();
// este minusculas
// function manejador (handler)
pulser.on('pulse', () => {
    // la función .on() llama el método .emit()
    // no hay un punto de distribución de eventos centralizado
    //cada instancia de eventEmmiter maneja sus propios listeners
    // y los distribuye a uno como este
console.log(`${new Date().toISOString()} pulse received`);
// el emmiter no recibe notificación alguna 
//(aquí lo mostramos por consola desde el listener)
});
// comienza a ejecutar funcion pulse
pulser.start();

// node pulsed.js