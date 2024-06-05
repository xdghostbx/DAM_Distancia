Sistema de Gestión de Inventario de Productos Electrónicos

El objetivo es crear una aplicación Java, llamada InventarioElectronicoApp, que permita gestionar el inventario de productos electrónicos. A través de un menú interactivo, los usuarios podrán realizar las siguientes operaciones:

1. Agregar un nuevo producto al inventario.
2. Ver el listado de productos disponibles (nombre, marca y disponibilidad).
3. Buscar información detallada de un producto por su código.
4. Vender un producto a un cliente.
5. Consultar el stock actual de un producto.
6. Actualizar la información de un producto.
7. Salir de la aplicación.

Cada producto será representado como un objeto de una clase base `Producto`, que contendrá la siguiente información común:

- Nombre.
- Marca.
- Código único de identificación.
- Precio unitario.
- Estado de disponibilidad (disponible o agotado).
- Cantidad en stock.

De Producto heredarán las clases específicas Smartphone y Portatil, que agregarán atributos propios de estos productos.

El programa debe cumplir con los siguientes requisitos:

- Utilizar un array para almacenar los objetos de tipo Producto.
- Implementar la interfaz Imprimible en la clase base Producto para obtener información detallada del producto como una cadena de caracteres.
- Crear una clase InventarioElectronico que mantenga como atributo la estructura que almacena los productos. Esta clase debe tener métodos para realizar todas las operaciones mencionadas en el menú.
- Validar la entrada del usuario según sea necesario (por ejemplo, no permitir vender productos agotados).

Además, crea al menos dos clases derivadas (Smartphone y Portatil) que hereden de Producto. Cada una de estas clases debe tener atributos específicos relacionados con la categoría de producto.

La interfaz Imprimible debe declarar un método devolverInfoString que devolverá la información del producto como una cadena de caracteres.

Organiza el código de manera clara y proporciona comentarios explicativos en cada atributo y método, así como en el código principal.