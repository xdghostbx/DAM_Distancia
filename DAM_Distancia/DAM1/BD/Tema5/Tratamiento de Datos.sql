EDICION DE INFORMACION MEDIANTE HERRRAMIENTAS GRAFICAS

1.- Para añadir registros mediante herramienta gáfica
    Tan solo es necesario pulsar el icono del +, añadir los datos y cuando
    estemos listos, darle al tick

2.- Modificacion de registros
    Seleccionamos la tabla, pestaña datos, en la columna o fila a modificar, click
    con el raton y escribimos el nuevo contenido y le damos al tick

3.- Borrado de registros
    Para eleminiar, pestaña datos, nos situamos en la fila o columna que
    queramos borrar y pulsamos en la X para cada una de las filas. Esto las marca
    en rojo, para terminar de borrarlas, hay que pulsar el click


EDICION DE INFORMACION MEDIANTE SENTENCIAS SQL

1.- Insercion de registros
    Mediante la sentencia INSERT
    Ejemplo:

    INSERT INTO nombre_tabla (lista_campos) VALUES (lista_valores);

    Al hacer un INSERT si no se especifican los valores de todos los 
    campos, se obtiene un NULL en aquellos que no se han indicado

2.- Modificacion de registros
    Mediante la sentencia UPDATE
    Ejemplo:

    UPDATE nombre_tabla SET nombre_campo = valor [, nombre_campo = valor]...
        [WHERE condicion];

    La clausula WHERE es opciona, de indicarse, la actualizacion de los datos
    solo afectara a los registros que cumplen la condicion
    Si no se indica la clausula WHERE, se actualizan todos los registros

    Ejemplo2: (se desea poner el credito de todos los usuarios a 200)

    UPDATE USUARIOS SET Credito = 200;

    Ejemplo3: (Se quiere cambiar todos los creditos de las mujeres a 300)

    UPDATE USUARIOS SET Credito = 300 WHERE Sexo = 'M';

3.- Borrado de registros
    Mediante la sentencia DELETE
    Ejemplo:

    DELETE FROM nombre_tabla [ WHERE condicion];

    Ejemplo2: (para borrar todos los registros de la tabla Usuarios)
    
    DELETE FROM Usuarios;

    Ejemplo3: (para eliminar todos los usuarios que tengan credito 0)
    DELETE FROM Usuarios WHERE Credito=0;
    