# Liskov Substitution Principle ~ LSP

## ¿Qué es?

**Todas las clases que hereden de otra, podrán usarse indistintamente** sin que eso rompa la aplicación, **incluyendo en ello a la clase padre**

+ Un ejemplo es tener una **clase** que use una **instancia** de la clase _WebFileDownloader_. Se debe de poder cambiar por una **instancia** de _FtpFileDownloader_ sin romper nada

(Siempre y cuando compartan la clase padre _FileDownloader_)


### Ejemplo

Supongamos que tenemos una jerarquía de clases para representar formas geométricas, donde cada forma tiene un método para calcular su área:

```java
class Forma {
    // Método para calcular el área
    public double calcularArea() {
        return 0;
    }
}

class Rectangulo extends Forma {
    private int ancho;
    private int altura;

    // Constructor y métodos específicos de Rectangulo
}

class Cuadrado extends Forma {
    private int lado;

    // Constructor y métodos específicos de Cuadrado
}
```

En este caso, violamos el Principio de Liskov porque el método _calcularArea()_ se comporta de manera diferente para _Rectangulo_ y _Cuadrado_.

La Refactorización para cumplir con el Principio de Liskov sería:

**Redefinir** la **relación** entre _Rectangulo_ y _Cuadrado_. 

En _lugar de heredar_ ambos de la clase _Forma_, podríamos **crear una interfaz** común Figura y luego hacer que _Rectangulo_ y _Cuadrado_ **implementen esa interfaz**. 

Además, el método _calcularArea_ debe ser consistente para todas las formas:

```java
interface Figura {
    double calcularArea();
}

class Rectangulo implements Figura {
    private int ancho;
    private int altura;

    // Constructor y métodos específicos de Rectangulo

    @Override
    public double calcularArea() {
        return ancho * altura;
    }
}

class Cuadrado implements Figura {
    private int lado;

    // Constructor y métodos específicos de Cuadrado

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
```

Con esta refactorización, ambas clases implementan la interfaz común _Figura_ y proporcionan una implementación coherente del método _calcularArea()_.