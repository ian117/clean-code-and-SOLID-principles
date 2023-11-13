# Open Closed Principle ~ OCP

Un artefacto software debe de estar **abierto para su extensión pero cerrado para su modificación**

Se debe de porder **aumentar** la **funcionalidad** de un **artefacto software** _sin la necesidad_ de **modificar el funcionamiento ya existente** en ese artefacto

### ¿Cómo se consigue?

Separando el software en **componentes con alta cohesión (SRP)**, y asegurándose de que **la dirección de las dependencias es la correcta(DIP)**

Debemos de **proteger los componentes de alto nivel de los cambios** surgidos **en los componentes de bajo nivel**

### Ejemplo

Si queremos agregar una nueva operación a la calculadora, estamos _modificando directamente_ la clase Calculadora para extenderla y agregar la operación de resta.

Esto viola el OCP porque estamos modificando una clase existente.

```java
// Clase que viola el OCP
class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
}

// Extensión de la clase para agregar una nueva operación
class CalculadoraConResta extends Calculadora {
    public int restar(int a, int b) {
        return a - b;
    }
}
```

La solución sería diseñar la clase Calculadora de manera que pueda ser extendida sin modificar su código.


```java
// Interfaz para las operaciones matemáticas
interface Operacion {
    int operar(int a, int b);
}

// Implementación de la suma
class Suma implements Operacion {
    public int operar(int a, int b) {
        return a + b;
    }
}

// Implementación de la resta
class Resta implements Operacion {
    public int operar(int a, int b) {
        return a - b;
    }
}

// Clase que utiliza las operaciones sin modificar su código
class Calculadora {
    public int calcular(int a, int b, Operacion operacion) {
        return operacion.operar(a, b);
    }
}
```

En este ejemplo, hemos creado una interfaz Operacion que define el método operar. 

Luego, implementamos esta interfaz en las clases Suma y Resta. 

La clase Calculadora ahora puede **realizar operaciones sin conocer los detalles de implementación**. 

Podemos **agregar** nuevas operaciones simplemente **creando nuevas clases** que implementen la **interfaz**, _sin_ **modificar** la clase Calculadora. 

Esto respeta el principio OCP.