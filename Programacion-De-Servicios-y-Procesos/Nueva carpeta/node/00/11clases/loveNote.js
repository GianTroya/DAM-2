const hereda= require ('./note');
// recordar que si utilizamos import(), no hace la funcion de buscar
class LoveNote extends hereda.Note {
    constructor(key, title, body, heart) {
    super(key, title, body);
    this._heart = heart;
    // no necesito declarar atributo nuevo fuera del constructor
    }
    get heart() { return this._heart; }
    set heart(newHeart) { return this._heart = newHeart; }
    }
// es como la herencia en JS
    var aLoveNote = new LoveNote( "Fa", "I love you Molly", "<3 <3","allMyHeart");
    var key = aLoveNote.key;
    var title = aLoveNote.title;
    console.log(aLoveNote)
    console.log(key)
    console.log(title)