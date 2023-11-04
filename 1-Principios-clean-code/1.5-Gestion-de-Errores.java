/**
 
 * Código debe ser limpio, pero robusto
 
 * Can be messy, that's why needs tobe structured
  

 *   COSAS A APLICAR *

    > Devolver excepciones en lugar de códigos de error✅
      Es más robusto, estructurado y practico, tener un sistema que espera un throw/Error que tener muchos IF statements que tengan Loggers, return json("Mensaje de error"), etc...

      Cuando tenermos una Arquitectura de Error Handling, nos damos mayor control y hasta libertad para poder gestionarlos como debe de ser

    > Usar excepciones Unchecked (Java) ✅
      Se refiere a usar errores que son responsabilidad del programador (Unchecked)

      En lenguajes como python/NodeJs, esto es automatico practicamente
      Solo se aplicaría el punto anterior (throw Exception)

    > No devolver ni pasar Null✅
       Cada función, si tiene que hacer un if(null) después de que se llama o cuando recibe los parametros, es desperdicio de código y son malas practicas

       ya que estamos encadenando que SIEMPRE, X función, puede regresar lo que debe + null

 */