# Dependency Inversion Principle ~ DIP

Los sistemás más flexibles son aquellos que **dependen de abstracciones y no de concreciones**

En un lenguaje como Java, eso significa que un **módulo** (clase) debe de depender de **interfaces y de clases abstractas y no de implementaciones volátiles[^1]**

> En otras palabras, las clases de alto nivel no deben depender directamente de las clases de bajo nivel,  ambas deben depender de abstracciones.

Esto hace necesario un _mecanismo_ que nos **cree las instancias** de las **implementaciones** que queremos

![](/Images/3-Principios-SOLID/Screenshot%20Capture%20-%202023-11-13%20-%2021-55-32.png)

+ Todas las dependencias apuntan a algo abstracto y no a algo concreto


## Consideraciones de este principio

+ Costoso (+ Tiempo y Exp para aplicar)

+ Posibilidad de utilizar **frameworks que aporten la inyección de dependencias**  (Spring, NestJs, Django[This last principle is kinda hard]...)

+ Si tienes la certeza de que una clase no es volátil[^1] (lógica de negocio), puedes depender de ella

+ Ante todo, **analizar si un módulo es volátil[^1] o no**, antes de decidir si abstraer las dependencias de esta forma



### Ejemplo

Supongamos que tienes una clase _LecturaArchivo_ que realiza operaciones de lectura de archivos y otra clase _ProcesadorTexto_ que depende directamente de _LecturaArchivo_:

```java
class LecturaArchivo {
    public String leerContenido(String nombreArchivo) {
        // Lógica para leer el contenido de un archivo
        return "Contenido del archivo";
    }
}

class ProcesadorTexto {
    private LecturaArchivo lectorArchivo = new LecturaArchivo();

    public void procesarArchivo(String nombreArchivo) {
        String contenido = lectorArchivo.leerContenido(nombreArchivo);
        // Lógica para procesar el contenido
    }
}
```

En este caso, _ProcesadorTexto_ depende directamente de _LecturaArchivo_

Lo que **viola el DIP** porque una clase de **nivel superior** (_ProcesadorTexto_) **depende** de una clase de **nivel inferior** (_LecturaArchivo_).

La **solución** sería **introducir** una **interfaz** (_FuenteDatos_) que _LecturaArchivo_ **implementará**. 

Luego, _ProcesadorTexto_ **dependerá** de esta **interfaz** en **lugar de depender directamente** de _LecturaArchivo_:

```java
// Interfaz para la fuente de datos
interface FuenteDatos {
    String leerContenido(String nombreArchivo);
}

// Implementación concreta de la interfaz
class LecturaArchivo implements FuenteDatos {
    public String leerContenido(String nombreArchivo) {
        // Lógica para leer el contenido de un archivo
        return "Contenido del archivo";
    }
}

// Clase de alto nivel dependiendo de la interfaz
class ProcesadorTexto {
    private FuenteDatos fuenteDatos;

    public ProcesadorTexto(FuenteDatos fuenteDatos) {
        this.fuenteDatos = fuenteDatos;
    }

    public void procesarArchivo(String nombreArchivo) {
        String contenido = fuenteDatos.leerContenido(nombreArchivo);
        // Lógica para procesar el contenido
    }
}
```

Ahora, _ProcesadorTexto_ **depende** de la **interfaz** _FuenteDatos_, cumpliendo con el DIP. 

Esto **permite una mayor flexibilidad**, ya que puedes **introducir** diferentes **implementaciones** de _FuenteDatos_ sin afectar a _ProcesadorTexto_ 

Por ejemplo si necesitas leer desde una base de datos en lugar de un archivo.



[^1]: Clase tiene una alta probabilidad de cambiar debido a variaciones en sus dependencias.