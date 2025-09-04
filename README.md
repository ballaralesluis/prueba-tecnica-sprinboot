# prueba-tecnica-sprinboot
Práctica de Spring Boot: CRUD de Vuelos

🌟Objetivo
Construir una aplicación Spring Boot (sin base de datos) que permita trabajar con una lista de vuelos y desarrollar un CRUD completo (Crear, Leer, Actualizar, Eliminar). El objetivo es aplicar buenas prácticas de diseño de API REST, estructuración de proyectos, uso de objetos de dominio y manipulación de fechas usando LocalDate.


Estructura del objeto Vuelo
La entidad Vuelodebe contener los siguientes atributos:

int id;
String nombreVuelo;
String empresa;
String lugarSalida;
String lugarLlegada;
LocalDate fechaSalida;
LocalDate fechaLlegada;



Ejemplo de instancia:

new Vuelo(
    1,
    "H001-V",
    "Iberia",
    "Madrid",
    "Buenos Aires",
    LocalDate.of(2025, 3, 10),
    LocalDate.of(2025, 3, 11)
);




🔄Funcionalidades del CRUD
Tu API debe permitir realizar las siguientes operaciones:


GET /vuelos → Obtener todos los vuelos ordenados por fecha de salida

GET /vuelos/{id} → Obtener un vuelo por su ID

POST /vuelos → Crear un nuevo vuelo

PUT /vuelos/{id} → Actualizar un vuelo existente

DELETE /vuelos/{id} → Eliminar un vuelo


Criterios de filtrado
Permitir el uso de filtros opcionales vía parámetros, por ejemplo:


/vuelos?empresa=Turkish→ Vuelos de esa aerolínea

/vuelos?lugarLlegada=New York→ Vuelos con destino a esa ciudad

/vuelos?fechaSalida=2025-03-10→ Vuelos con esa fecha de salida

Los filtros se podrán combinar.


🌍Estructura del proyecto
El proyecto debe estar organizado, como mínimo, con los siguientes paquetes:


models:para la claseVuelo

dtos

utils: para una clase utilitaria que ayuda con el manejo de fechas

controllers: para exponer el punto final principal

services: lógica y filtros

repositories: MIERDA



🏆Generación de datos

Crear una lista de 10 vuelos distintos .
Puedes usar aerolíneas reales (Iberia, Turquía, Emiratos, etc.).
Las ciudades de salida/llegada pueden repetirse entre vuelos.



📊Recomendaciones adicionales

Implementa validaciones básicas en el controlador o servicio. Por ejemplo no permitir:

vuelos sin nombre o con campos nulos
que la fechaIniciomar superior afechaFinal





Bono (opcional):

Permitir ordenar la lista por empresao lugarLlegadamediante un parámetro extra:


GET /vuelos?ordenarPor=lugarLlegada



Agregar un campo duracionDiasque calcula automáticamente la duración del vuelo en días cuando se devuelve el dato (JSON).



CARTERO

IMPORTANTE: Guardar en el repositorio la colección POSTMAN con todas las peticiones a la API
