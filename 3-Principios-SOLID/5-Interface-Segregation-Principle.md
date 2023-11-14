# Interface Segregation Principe ~ ISP

Este principio establece que **ningún cliente debe depender de métodos que no use**

En el siguiente ejemplo se muestra una representación en la cual, se incumple este principio. 

Ya que se implementan métodos que no se utilizan en Clases.

![](/Images/3-Principios-SOLID/Screenshot%20Capture%20-%202023-11-13%20-%2020-37-49.png)


---

En un lenguaje como Java, **un cambio en una operación, obligará al resto de usuarios a recompilar el módulo (clase)**, aunque nada de lo que use haya cambiado.

![](/Images/3-Principios-SOLID/Screenshot%20Capture%20-%202023-11-13%20-%2020-41-27.png)


### Ejemplo

Supongamos que tenemos una interfaz general para un trabajador que realiza tareas y también administra proyectos:

```java
interface Trabajador {
    void realizarTarea();
    void administrarProyecto();
}

class Desarrollador implements Trabajador {
    // Implementación de realizarTarea y administrarProyecto
}

class GerenteProyecto implements Trabajador {
    // Implementación de realizarTarea y administrarProyecto
}
```

En este caso, el problema es que _Desarrollador_ y _GerenteProyecto_ están obligados a implementar métodos que no son relevantes para su rol. 

Por ejemplo, un _desarrollador_ puede no tener la responsabilidad de administrar un proyecto.

La solución sería **dividir la interfaz** _Trabajador_ en **interfaces** más **pequeñas y específicas** para **cada función**:

```java
// Interfaz para los trabajadores que realizan tareas
interface TrabajadorTareas {
    void realizarTarea();
}

// Interfaz para los trabajadores que administran proyectos
interface TrabajadorProyectos {
    void administrarProyecto();
}

// Implementación para un desarrollador
class Desarrollador implements TrabajadorTareas {
    // Implementación de realizarTarea
}

// Implementación para un gerente de proyecto
class GerenteProyecto implements TrabajadorProyectos {
    // Implementación de administrarProyecto
}
```

Ahora, las **clases implementan solo las interfaces** que son **relevantes** para su **función**. 

Un _Desarrollador_ implementa _TrabajadorTareas_, mientras que un _GerenteProyecto_ implementa _TrabajadorProyectos_. 

Esto sigue el Principio de Segregación de Interfaces al **evitar que las clases implementen métodos** que **no necesitan**.