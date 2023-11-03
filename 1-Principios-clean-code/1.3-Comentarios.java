/**
 * El código limpio se debe de leer sin ningún comentario
  
 * Solo añadir cuando sea necesario
  
 * Ya que son complicados de mantener y son desactualizados rapidamente
  
 * Es muy común que los comentarios se deban a que el código no se entiende o sean muy obvios
 
 * Cada una de esta situación se resuelve con refactorización y eliminando estos comentariis
  
 */


//Ejemplos malos comentarios

// ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----
//check if password is secure
if(password != null && password.length > 9 && !password.contains(username))  ❌


if (isSecure(password)) ✅

// ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----

//Se obvia, y no se encadena no hacer cambios
private String date; // The date as String

private Date date; // The date as String

// ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----

//   "Guardar" código que no se usa para después está mal, mejor usar Git o algo así
// const doingComments = () => {

// }

// ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----

//✅
// Comentarios para explicar REGEX está bien✅
// Hacer TODO's✅
// JavaDocs o en otros de una API✅