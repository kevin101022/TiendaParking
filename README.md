# TiendaParking

Proyecto de gestión de parqueadero y registro de viajes en Java.

## Modelos del Sistema

El proyecto cuenta con las siguientes entidades en el paquete `model`:

* **`Carro_modelo`**: Representa a los vehículos con los atributos de placa, color, marca y modelo.
* **`Motor_modelo`**: Almacena el tipo de motor, los caballos de fuerza y el número de serie.
* **`chofer_modelo`**: Almacena la información del chofer incluyendo cédula, nombre, apellido y su tipo de licencia.
* **`Pasajero_modelo`**: Almacena los datos del pasajero (cédula y nombre completo).
* **`FichaViaje_modelo`**: Estructura de datos que unifica y centraliza toda la información de un viaje (Carro, Motor, Chofer y Pasajero) en un único registro.

## API y Simulación de Base de Datos

La clase **`Api_Modelo`** actúa como la capa de conexión y de negocio con la base de datos simulada:

* **Conexión**: Métodos `validar_conexion()` (verifica clave `"1234"`) y `desconexion()`.
* **Estructura Temporal**: Utiliza un `ArrayList<FichaViaje_modelo>` llamado `temporal_viajes` para guardar temporalmente las fichas de viaje de manera externa antes de persistirlas.
* **CRUD de Consola**: Métodos para ingresar, buscar y eliminar información de carros, motores, choferes y pasajeros.
