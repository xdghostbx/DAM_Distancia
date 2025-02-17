Ejercicio 1: Sistema de Gestión de Inventario (Estructuras de Almacenamiento de Información y Utilización Avanzada de Clases)

Enunciado:

Desarrolla un programa en Java que gestione el inventario de una tienda. El programa debe permitir:

    Añadir un producto al inventario. Cada producto tendrá un código único, nombre, cantidad en stock y precio.
    Eliminar un producto del inventario mediante su código.
    Actualizar la cantidad en stock de un producto específico.
    Mostrar la lista completa de productos en el inventario.

Para realizar esta gestión, crea una clase Producto con los siguientes atributos y métodos:

    Atributos:
        codigo (String)
        nombre (String)
        cantidad (int)
        precio (double)

    Métodos:
        Constructor que inicialice todos los atributos.
        Métodos getter y setter para todos los atributos.
        Método toString para mostrar la información del producto de manera legible.

Adicionalmente, crea una clase Inventario que utilice una estructura de almacenamiento adecuada (puedes usar un ArrayList<Producto> o un HashMap<String, Producto>). Esta clase debe tener los métodos necesarios para añadir, eliminar, actualizar y mostrar los productos.

Requisitos:

    Usa una estructura de almacenamiento adecuada para gestionar los productos.
    Implementa manejo de excepciones para evitar errores como la adición de productos con el mismo código o la eliminación de productos que no existen.
    Asegúrate de que el programa es interactivo y permite al usuario realizar las operaciones a través de un menú en la consola.