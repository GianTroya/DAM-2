
module.exports.Note= class Note { 
      //primero ejecutar este  note.js, antes debo 
      // comento la de arriba y descomento too lo de abajo
      // código cliente
      // class Note { 
        constructor(key, title, body) {
            this._key = key;
            this._title = title;
            this._body = body;
            }
            // aquí si quiero hacer privados los atributos es con _
            // luego los get o set separados del nombre atributo sin _
            get key() { return this._key; }
            get title() { return this._title; }
            set title(newTitle) { return this._title = newTitle; }
            get body() { return this._body; }
            set body(newBody) { return this._body = newBody; }

     }
    //  var aNote = new Note("key", "The Rain in Spain", "Falls mainly on theplain");
    //  var key = aNote.key;
    //  var title = aNote.title;
    //  aNote.title = "The Rain in Spain, which made me want to cry with joy";
    //  console.log(aNote)





     

