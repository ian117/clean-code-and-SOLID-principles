# Single Responsability Principle ~ SRP 

+ "**Un módulo debe de tener una única razón para cambiar**"

    Un módulo es una Clase

+ Un módulo debe de ser **responsable de solo un usuario o interesado** del sistema


### Síntoma 1: Duplicidad Accidental

+ Cuando una clase es responable de más de 1 actor y tiene muchas razones de cambio

+ Si uno de los 2 actores necesita un cambio en el algoritmo, **afectará al otro**

![](/Images/3-Principios-SOLID/Screenshot%20Capture%20-%202023-11-12%20-%2018-00-57.png)

+ Si ese algoritmo se abstrae a una clase o función, **2 actores muy distintos compartirán código**


### Síntoma 2: Merges de Código

+ Si es necesario realizar merges a menudo, es muy **probable que se incumpla el SRP**

+ 2 Desarrolladores hacen un checkout para **modificar la misma clase por razones disintas**.
Resulta en un merge, que puede afectar al código que implementó otro programador




## Ejemplo del SRP


```java
// Clase que viola el SRP
class GestorEmpleado {
    public void guardarEmpleado(Empleado empleado) {
        // Lógica para guardar en la base de datos
    }

    public void generarReporte(Empleado empleado) {
        // Lógica para generar un reporte
    }
}

// A partir de aquí es la refactorización de arriba ->

// Clase de ejemplo de un empleado
class Empleado {
    private String nombre;
    private double salario;

    // Getters y setters
}

// Solución aplicando SRP
class EmpleadoRepository {
    public void guardarEmpleado(Empleado empleado) {
        // Lógica para guardar en la base de datos
    }
}

class ReporteEmpleado {
    public void generarReporte(Empleado empleado) {
        // Lógica para generar un reporte
    }
}
```

En el ejemplo anterior, la clase GestorEmpleado viola el SRP porque tiene dos responsabilidades: guardar un empleado en la base de datos y generar un reporte.
 
La **solución** es **dividir** esas **responsabilidades** en dos clases separadas: _**EmpleadoRepository**_ para la persistencia en la base de datos y _**ReporteEmpleado**_ para la generación de informes. 

Ahora **cada clase** tiene **una única responsabilidad**. 

Esto facilita el mantenimiento y la extensión del código, ya que los cambios en la lógica de persistencia no afectarán la generación de informes y viceversa.