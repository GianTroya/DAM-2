# 🧠 Guía personalizada: dudas resueltas sobre gestión de ficheros en Java

## 1. ¿Qué significa crear un pathname?
- Un pathname es una **ruta textual** que representa la ubicación de un archivo o carpeta.
- `new File("unidad1_ejemplos")` crea una **referencia** a esa ruta, no la carpeta en sí.
- Para crearla físicamente, se usa `mkdir()` o `mkdirs()`.

## 2. ¿Dónde se crea la carpeta si uso una ruta relativa?
- Se crea en el **mismo directorio** donde se ejecuta el programa.
- `"unidad1_ejemplos"` es una ruta **relativa**.

## 3. ¿Puedo llamar a la variable `directorioEjemplo` como `rutaDirectorio`?
- ¡Sí! Es más claro y refleja que estás trabajando con una **ruta**, no con una carpeta creada aún.

## 4. ¿Qué hace `new File(directorio, nombreArchivo)`?
- Crea una ruta combinada: el archivo estará dentro del directorio especificado.
- Sirve tanto para **archivos** como para **subcarpetas**.

## 5. ¿Cómo referencio rutas más complejas?
- Carpetas anidadas: `"datos/archivos/miArchivo.txt"`
- Subir niveles: `"../miArchivo.txt"`
- Ruta absoluta: `"C:/Usuarios/TuNombre/Documentos/miArchivo.txt"`

## 6. ¿Es necesario poner la extensión del archivo?
- Sí. Java **no la añade automáticamente**.
- Si no la pones, el archivo se crea sin extensión.

## 7. ¿Qué hace `getAbsolutePath()`?
- Devuelve la **ruta completa** del archivo en el sistema.
- Útil para confirmar la ubicación real.

## 8. ¿Qué hace `createNewFile()`?
- Crea el archivo si no existe.
- Devuelve `true` si lo crea, `false` si ya existía.
- No sobrescribe ni modifica archivos existentes.

## 9. ¿Qué es una excepción de E/S (`IOException`)?
- E/S = Entrada/Salida.
- `IOException` se lanza si hay problemas al acceder al sistema de archivos.
- Se maneja con `try-catch` o `throws IOException`.

## 10. ¿Qué propiedades puedo consultar de un fichero?
- `exists()` → ¿Existe?
- `isFile()` → ¿Es un archivo?
- `isDirectory()` → ¿Es una carpeta?
- `canRead()` → ¿Se puede leer?
- `canWrite()` → ¿Se puede escribir?
- `length()` → Tamaño en bytes

## 11. ¿Qué pasa si el fichero ya existía?
- `createNewFile()` no lo sobrescribe ni lo borra.
- Devuelve `false` y no lo modifica.

## 12. ¿Puedo hacer `File fichero = rutaFichero.createNewFile()`?
- ❌ No. `createNewFile()` devuelve un **boolean**, no un objeto `File`.

## 13. ¿Solo se manejan rutas con `File`?
- No. `File` representa una ruta que puede ser:
  - Un archivo
  - Una carpeta
  - Algo que aún no existe

## 14. ¿Qué pasa si quiero borrar el fichero y el directorio?
- Usa `delete()` sobre el fichero y luego sobre el directorio.
- El directorio solo se borra si está **vacío**.