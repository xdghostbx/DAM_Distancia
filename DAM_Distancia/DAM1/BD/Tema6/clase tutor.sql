
--registros
--un registro es una unica tupla de una tabla, tiene un tipo de dato y una cantidad de atributos, pueden ser nulos o no, pueden tener tipos de datos difrentes 
--la forma de declarar un registro es la misma que la de declarar una tabla
-- pra declarar un registro, en la parte del declare ponemos:

DECLARE

    TYPE persona IS RECORD(
        dni char(9),
        nombre VARCHAR2(20),
        apellido VARCHAR2(20),
        f_naz DATE
    );
    
    yo persona; --declaramos una variable del tipo persona
    
    mi_piso piso%ROWTYPE;--pilla los datos de toda la tabla
BEGIN
    SELECT * INTO mi_piso FROM piso WHERE dni_propietario like '32132132X'; --si devuelve mas de una fila, no funciona
    DBMS_OUTPUT.PUT_LINE(mi_piso.calle);
END;
-----------------------------------------------------------------------------------------------------------------------------------

--CURSORES
/*Vamos a intentar ver 3 cosas
    CURSORES
    PROCEDIMIENTOS
    FUNCIONES
    
2 tipos implicitos e explicitos
Explicitos (los que son necesarios para la mayor parte de funciones)
Un cursor es una parte de la memoria principal del pc que se reseva para los resultados de una consulta
Un cursor tiene asociada una consulta y los datos se guardan en memoria y son inmutables
Tienen varias propiedades

    %FOUND
    %NOTFOUND
    %ROWCOUNT
    %ISOPEN
    
COn un cursor podemos abrirlos, cerrarlos, ejecutar las diferentes filas del cursos (fetch) y declararlos
Al abrir un cursor se ejecuta la consutla asociada, no siempre da los mismos datos ya que las bbdd son dinamicas

Al abrirlos se ejecuta el select y recorremos las distintas filas (fetch) mete las variables y salta a la siguiente fila
Por ultimo, lo cerramos (liberando el espacio de memoria que usaba)

EJEMPLO*/
--recorrer los municipios y sacarlos uno a uno por pantalla

SET SERVEROUTPUT ON;


DECLARE 
    municipioActual municipio%ROWTYPE;
    CURSOR munisC IS 
        SELECT * FROM municipio;
BEGIN
    --1. Abrimos el cursor
    IF munisC%ISOPEN THEN
        DBMS_OUTPUT.PUT_LINE('Linea 37 abierto');
    END IF;
    OPEN munisC; --%ISOPEN devuelve TRUE
    IF munisC%ISOPEN THEN
        DBMS_OUTPUT.PUT_LINE('Linea41 abierto');
    END IF;
    
    FETCH munisC INTO municipioActual;
    DBMS_OUTPUT.PUT_LINE('Primer FETCH: '||municipioActual.nombre);
    
    FETCH munisC INTO municipioActual;
    DBMS_OUTPUT.PUT_LINE('Segundo FETCH: '||municipioActual.nombre);
    
    
    CLOSE munisC;
    IF munisC%ISOPEN THEN
        DBMS_OUTPUT.PUT_LINE('Linea 45 abbierto');
    END IF;
END;


--Ejemplo basico de bucle para recorrer todos los municipios

DECLARE 
    municipioActual municipio%ROWTYPE;
    CURSOR munisC IS 
        SELECT * FROM municipio;
BEGIN
    --1. Abrimos el cursor
    IF munisC%ISOPEN THEN
        DBMS_OUTPUT.PUT_LINE('Linea 37 abierto');
    END IF;
    OPEN munisC; --%ISOPEN devuelve TRUE
    IF munisC%ISOPEN THEN
        DBMS_OUTPUT.PUT_LINE('Linea41 abierto');
    END IF;
    --caso 1: repite el ultimo resultado al cargar el fetch, imprimir y luego salir del bucle
    LOOP
        FETCH munisC INTO municipioActual;
        DBMS_OUTPUT.PUT_LINE('Municipio: '||municipioActual.nombre||' '||munisC%ROWCOUNT); --imprime el municipio con el numero de columna que lleva
        EXIT WHEN
            munisC%NOTFOUND; 
    END LOOP;
    --caso 2: al imprimir despues del exit, no repite el ultimo valor. Esta es la forma correcta para evitar fallos
    LOOP
        FETCH munisC INTO municipioActual;
        EXIT WHEN
            munisC%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE('Municipio: '||municipioActual.nombre||' '||munisC%ROWCOUNT); --imprime el municipio con el numero de columna que lleva    
    END LOOP;
    CLOSE munisC;
    IF munisC%ISOPEN THEN
        DBMS_OUTPUT.PUT_LINE('Linea 45 abbierto');
    END IF;
END;

--CURSORES IMPLICITOS
--Se crean con into, update, insert
SET SERVEROUTPUT ON;

DECLARE 
    municipioActual municipio%ROWTYPE;
    CURSOR munisC IS 
        SELECT * FROM municipio WHERE cod_provincia = 36;
BEGIN
    --1. Abrimos el cursor
    OPEN munisC; --%ISOPEN devuelve TRUE

    --caso 2: al imprimir despues del exit, no repite el ultimo valor. Esta es la forma correcta para evitar fallos
    LOOP
        FETCH munisC INTO municipioActual;
        EXIT WHEN
            munisC%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE('Municipio: '||municipioActual.nombre||' '||munisC%ROWCOUNT); --imprime el municipio con el numero de columna que lleva    
    END LOOP;
    CLOSE munisC;
END;

-- para que el dato que queremos filtrar sea dinamico hacemos lo siguiente, cursores parametrizados

SET SERVEROUTPUT ON;
DECLARE 
    prov NUMERIC;
    municipioActual municipio%ROWTYPE;
    CURSOR munisC (cod_p NUMBER) IS 
        SELECT * FROM municipio WHERE cod_provincia = cod_p; --con un and podemos poner varios cursores parametrizados
BEGIN
    prov := 27;
    --1. Abrimos el cursor
    OPEN munisC (prov); --abre con el dato 27, sin necesidad de ponerlos notros a mano. Podemos añadir mas con (prov, tal) o (prov, literal)

    --caso 2: al imprimir despues del exit, no repite el ultimo valor. Esta es la forma correcta para evitar fallos
    LOOP
        FETCH munisC INTO municipioActual;
        EXIT WHEN
            munisC%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE('Municipio: '||municipioActual.nombre||' '||munisC%ROWCOUNT); --imprime el municipio con el numero de columna que lleva    
    END LOOP;
    CLOSE munisC;
END;

-----------------------------------------------------------------------------------------------------------------------------------------------------
--CURSORES IMPLICITOS
--CURSORES IMPLICITOS
--Se crean con into, update, insert
SET SERVEROUTPUT ON;

DECLARE 
    municipioActual municipio%ROWTYPE;
    CURSOR munisC IS 
        SELECT * FROM municipio;
BEGIN

    SELECT * INTO municipioActual FROM municipio WHERE cod_municipio = 36004;
     DBMS_OUTPUT.PUT_LINE('sql%rowcount '||sql%rowcount);
END;

--Ejemplo
/*
Cambiar los nombres de las provincias y que sean en mayus
*/
UPDATE provincia SET nombre = UPPER(nombre);

--en plsql sería (para saber tambien cuantas filas se actualizan)

SET SERVEROUTPUT ON;

DECLARE 
    municipioActual municipio%ROWTYPE;
    CURSOR munisC IS 
        SELECT * FROM municipio;
BEGIN
    UPDATE provincia SET nombre = UPPER(nombre);
    IF sql%FOUND THEN
         DBMS_OUTPUT.PUT_LINE('se han actualizado '||sql%rowcount||' numero de filas');
    ELSE
        DBMS_OUTPUT.PUT_LINE('no se han realizado cambios');
    END IF;     
END;

SELECT * FROM PROVINCIA;

SET SERVEROUTPUT ON;

DECLARE 
    municipioActual municipio%ROWTYPE;
    CURSOR munisC IS 
        SELECT * FROM municipio;
BEGIN
    UPDATE provincia SET nombre = LOWER(nombre) WHERE cod_provincia > 40;
    IF sql%FOUND THEN
         DBMS_OUTPUT.PUT_LINE('se han actualizado '||sql%rowcount||' numero de filas');
    ELSE
        DBMS_OUTPUT.PUT_LINE('no se han realizado cambios');
    END IF;     
END;


-----------------------------------------------------------------------------------------------
--Funciones

DECLARE
    prov NUMERIC;
    actual alumno%ROWTYPE;
    CURSOR AlEd is SELECT * FROM alumno;
    
    FUNCTION getEdad(f_naci IN DATE) RETURN INT
    AS 
    --aqui empieza la funcion. Esta zona entre el AS y el Begin es el equivalente al DECLARE
    -- las variables que declaramos aqui solo existen en esta propia funcion
        edad INT := 0;
    BEGIN
        edad := FLOOR(Months_Between(Sysdate, f_naci)/12);
        IF edad < 0 THEN
            edad := 0;
        END IF;
        RETURN edad; --devuelve el tipo de dato que le indicamos a la funcion
    END;
    
BEGIN
    open AlEd;
    LOOP
        FETCH AlEd into actual;
        EXIT WHEN AlEd%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(actual.nombre||' '||actual.fecha_naci||' '||getEdad(actual.fecha_naci));
    END LOOP;    
END;

--Como no es rentable, podemos crear funciones como objetos, de la sigyuiente manera

CREATE OR REPLACE
FUNCTION getEdad(f_naci IN DATE) RETURN INT
    AS 
    --aqui empieza la funcion. Esta zona entre el AS y el Begin es el equivalente al DECLARE
    -- las variables que declaramos aqui solo existen en esta propia funcion
        edad INT := 0;
    BEGIN
        edad := FLOOR(Months_Between(Sysdate, f_naci)/12);
        IF edad < 0 THEN
            edad := 0;
        END IF;
        RETURN edad; --devuelve el tipo de dato que le indicamos a la funcion
    END;
    
--Y lo podriamos ejecutar solo con poner el nombre de la funcion   

SELECT nombre, fecha_naci, getEdad(fecha_naci) as Edad FROM alumno;


--- Otra forma de crear funciones (de forma grafica)ç
--vamos a la carpeta de funciones y click derecho, nueva funcio

---------------------------------------------------------------------------------------------
--Procedimiento, es lo mismo que una funcion pero que no devuelve datos (sin el return)
/*
Agregar datos aleatorios a una base de datos para probar la base de datos
Crear un alumno y matricularlo en una escuela
Hay que generar datos aleatorios menos el codigo que es el maximo +1
*/
--Esta parte es la que sube el como ejercicio, tengo este codigo pero lleno de errores, pero los comentarios van bien
SELECT DISTINCT NOMBRE, SEXO FROM ALUMNO; --guardar estos datos en un cursor
sexo CHAR(1);
nombre alumno%nombre;
DECLARE 
    FUNCTION getNombre (sexo out char) return VARCHAR2 AS
        CURSOR alsC IS 
            SELECT DISTINCT NOMBRE, SEXO FROM ALUMNO;
            TYPE nombreRegistro IS RECORD ( --guardamos en una estructura de datos lo que devuelva el cursor en un formato tipo tabla (como un array)
                nombre alumno.nombre%TYPE,
                sexo alumno.sexo%TYPE
            );
            TYPE nombreTabla IS TABLE OF nombreRegistro;
            nombres nombreTabla := nombreTabla(); --crear variable tipo tabla (array)| variable nombres del tipo nombreTabla e inicializamos el array
            actual nombreRegistro;
            numAleatorio int := 1;
    BEGIN
        OPEN alsC; --abrimos el cursor que creamos antes
        LOOP
            FETCH alsC INTO actual;
            EXIT WHEN alsC%NOTFOUND;
            --aqui hacemos el bucle en cada fila que devuelve el cursor, en este caso, meterlo dentro de la tabla
            nombres.EXTEND();
            nombres(nombres.COUNT()) := actual; --count es  como el .lengh de java junto con extends, añada un +1 al"indice"
        END LOOP;
        --ahora tenemos la tabla nombres con los elemetos distintos de la tabla alumnos
        --generamos el numero aleatorio entre 1 y la pos maxima de la tabla nombres 
        numAleatio := dbms_random.value(1, nombres.count());
        actual := nombres(numAleatiorio);
        SEXO := actual.SEXO;
        RETURN actual.NOMBRE;
    END;
BEGIN
    nombre := getNombre(sexo);
    BMS_OUTPUT.PUT_LINE(nombre||' - '||sexo);
END;