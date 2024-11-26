Este backend es una API RESTful para gestionar un CRUD (Crear, Leer, Actualizar, Eliminar) de productos. Utiliza una arquitectura Modelo-Vista-Controlador (MVC), el patrón de diseño DTO (Data Transfer Object) para la transferencia de datos, y MongoDB como sistema de gestión de base de datos NoSQL creada en MongoDB Atlas Database (https://www.mongodb.com/products/platform/atlas-database).

La arquitectura MVC divide la aplicación en tres componentes principales para mejorar la modularidad y el mantenimiento:

  -Modelo (Model): Define la estructura de los datos, en este caso el producto.
  
  -Vista (View): Aunque la vista se usa en la capa frontend, aquí se hace referencia a cómo los datos se representan.
  
  -Controlador (Controller): Maneja las solicitudes HTTP, invoca los servicios adecuados y devuelve las respuestas.
  
 1-Modelo (Entity): La entidad Producto se define como un objeto de dominio que representa los datos que se almacenarán en la base de datos MongoDB.
 
 2-DTO (Data Transfer Object): El patrón DTO se usa para transferir los datos de forma más controlada y desacoplada entre las capas del backend. El DTO define solo los campos que queremos     exponer al cliente.
 
 3-Repositorio (Repository): El repositorio proporciona una abstracción de la base de datos, permitiendo realizar las operaciones CRUD de manera eficiente y desacoplada.
 
 4-Servicio (Service): El servicio contiene la lógica de negocio y se encarga de coordinar las operaciones entre el repositorio y el controlador. Además, se asegura de mapear las entidades    a DTOs.
 
 5-Controlador (Controller): El controlador se encarga de recibir las solicitudes HTTP, invocar el servicio adecuado, manejar las excepciones y devolver las respuestas con los códigos de     estado correspondientes.

 Manejo de Excepciones y Códigos de Estado HTTP:
 404 Not Found: Si no se encuentra un producto en la base de datos (en el servicio o repositorio), se lanza una excepción ProductoNotFoundException y el controlador responde con un código 
 HTTP 404 Not Found.
 
 500 Internal Server Error: Para errores inesperados, como un fallo en la base de datos o en la lógica de negocio, se responde con un código 500 Internal Server Error, junto con detalles 
 del error en el cuerpo de la respuesta.
 
 200 Created: Cuando un nuevo producto se crea correctamente, el controlador responde con un 201 Created y una ubicación del nuevo recurso.
 
