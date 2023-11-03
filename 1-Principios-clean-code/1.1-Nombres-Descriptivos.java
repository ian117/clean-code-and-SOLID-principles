/**
 * Nombres que revelen intención (No esconder objetivos) 

 * Evitar la desinformación (Ser Claro)

 * Uso de nombres pronunciables y descriptivos
 */


// ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----

// Nombres de Clases y Métodos

// 👌Nombres de Classes deben de ser un nombre o un conjunto de nombres, NO deben de ser verbos
// 👌Los nombres de Métodos deben de ser verbos (Una Acción)


// Examples

// ❌
public class CreateEmployee() {
    public void EmployeeName() {}; ❌
}
; 

//✅
// EmployeeCreator, EmployeeBuilder/Geenerator, hasta Employee podría ser, étc.
public class EmployeeCreator(){
    public void getEmployeeName() {}; ✅
};


// ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----

// Contexto General

// Se puede incluir  un prefijo para aportar información

String street,number,inside_number; // En un contexto general, no vemos contexto

// Si el código está en un paquete o se usa en un apartado en donde se sepa el uso
// En este caso, de ---> Dirección, sabremos que se hará.
// Pero si no, solo crea confución

//Añadir un prefijo puede ayudar a siempre tener en cuenta el contexto
String addrStreet,addrNumber,addrInside_number;
String addr_street,addr_number,addr_inside_number;

//Si la palabra para el prefijo puede ser confundida, mejor usar la palabra completa (Ser claro)
String lst_lower_number,lst_highest_number; ❌ // Querrá decir list, least, o last???
String list_lower_number,list_highest_number; ✅ // Almenos no hay confución


