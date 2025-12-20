const EventEmitter = require('events');
// el objeto EventEmitter está definido en los módulos
// de eventos de node, en la mayoría de los casos
// no requeriremos este módulo ya que usaremos un objeto
// existente que lo utiliza, aquí interesa heredar la clase
class Pulser extends EventEmitter {
    start() {
        setInterval(() => {
                                        //  esto es el envio
            console.log(`${new Date().toISOString()} >>>> pulse`);
            this.emit('pulse'); // esto emite un evento
            // a cualquier listener registrado
            // this aquí es igual que afuera de la función
            // porque es una arrow function, esto era otra 
            // de las diferencias de usar arow functions
            // si quisiéramos usar una función necesitraríamos 
            //var self=this; y luego utilizar self.loQueSea()
            console.log(`${new Date().toISOString()} <<<< pulse`); 
                                       //  esto la recepción

        }, 1000);
    }
}
module.exports = Pulser;

//si necesitamos únicamente un EventEmitter
// class HeartBeat extends EventEmitter {}
// const beatMaker = new HeartBeat();

// define clase pulser que hereda de EventEmitter

// ahora hace falta un js que consuma pulser.js (pulsed)