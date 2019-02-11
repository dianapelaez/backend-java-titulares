# backend-java-titulares
Titulares de cuentas corrientes

1. Ejercicio
Se debe tener en cuenta antes de iniciar el servidor, crear el schema "examentecsoauto" en la base de datos mysql,
y modificar los valores de username y password por los de la base de datos de su conexion, las tablas se generaran automaticamente.

Se debe agregar el complemento CORS en el navegador para intercambio entre los puertos de java y angular.

2. Ejercicio
Url de endpoints requeridos en la capa REST:
-  Crear cuenta: POST, http://localhost:8000/api/cuentacorriente
- Eliminar cuenta: DELETE, http://localhost:8000/api/cuentacorriente
- Listar Cuentas: GET, http://localhost:8000/api/cuentacorriente
- Agregar Movimiento: POST, http://localhost:8000/api/movimiento
- Listar movimientos por cuenta (ordenados de forma decreciente por fecha): GET, http://localhost:8000/api/movimiento/{idCuenta}
