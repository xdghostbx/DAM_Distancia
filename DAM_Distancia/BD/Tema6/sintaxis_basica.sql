/*
Sintaxis crear funciones
*/

CREATE FUNCTION NombreDeLaFuncion (param1 tipo, param2 tipo, ...)
RETURNS tipo
AS
BEGIN
    -- Código SQL
    RETURN valor;
END;

/*
Sintaxis cursores
*/

DECLARE CursorNombre CURSOR FOR
SELECT columna1, columna2 FROM tabla WHERE condición;
OPEN CursorNombre;
FETCH NEXT FROM CursorNombre INTO @var1, @var2;
WHILE @@FETCH_STATUS = 0
BEGIN
    -- Procesar cada fila
    FETCH NEXT FROM CursorNombre INTO @var1, @var2;
END;
CLOSE CursorNombre;

/*
Sintaxis procedimientos
*/

CREATE PROCEDURE NombreDelProcedimiento (param1 tipo, param2 tipo, ...)
AS
BEGIN
    -- Código SQL
END;

/*
Sintaxis excepciones
*/

BEGIN
    -- Código SQL que puede causar un error
EXCEPTION
    WHEN nombre_de_excepcion THEN
        -- Manejo del error
END;

/*
Sintaxis triggers
*/

CREATE TRIGGER NombreDelTrigger
BEFORE INSERT ON tabla
FOR EACH ROW
AS
BEGIN
    -- Código SQL que se ejecuta antes de cada inserción
END;

/*
1. Crea una función a la que le pasaremos como parámetros de entrada: MATRICULA, NUEVO_PRECIO_COMPRA. la función modificara los datos
del coche que tenga la matricula introducida actualizando el precio_compra de la siguiente forma:

-Si precio_compra es nulo hacer un update en el campo precio_compra asignándole el valor de nuevo_precio_compra

-Si no hacer un update en el campo precio_compra asignándole el valor de precio_compra+(precio_compra-nuevo_precio_compra).

La función devolverá el numero de filas actualizadas crea un bloque anónimo que ejecute la función anterior y muestre el resultado devuelto por la función.
*/
SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION f_modificar (
    f_matricula coche.matricula%TYPE,
    n_precio coche.precio_compra%TYPE)
    RETURN NUMBER
IS
v_precio coche.precio_compra%TYPE;
BEGIN
    SELECT precio_compra into v_precio
    FROM coche
    where matricula = f_matricula;
    
    if v_precio is null then
        UPDATE coche
        SET precio_compra = n_precio
        where matricula = f_matricula;
        
        DBMS_OUTPUT.PUT_LINE('El precio ha pasado de nulo a algun valor');
    else
        UPDATE coche
        SET precio_compra = precio_compra + n_precio
        where matricula = f_matricula;
        
        DBMS_OUTPUT.PUT_LINE('El precio se ha sumado');
    end if;
    
    RETURN SQL%ROWCOUNT;
END f_modificar;

DECLARE 
    f_matricula coche.matricula%TYPE := '3346GVA';
    precio coche.precio_compra%TYPE := 10000;
    filas NUMBER;
BEGIN 
    filas := f_modificar (f_matricula,precio);
    DBMS_OUTPUT.PUT_LINE('se modificaron '||filas);
END;   

select * from coche;

    


/*
Imprimir hola mundo
*/
BEGIN
    dbms_output.put_line('Hola mundo');
END;

/*
bloque que cunte el numero de filas que hay en la tabla clientes
*/

DECLARE 
    filas NUMBER;
BEGIN
    SELECT count(*) into filas
    FROM cliente;
    dbms_output.put_line(filas);
END;    

/*
Escribir un procedimiento que reciba dos números y visualice su suma
*/

CREATE OR REPLACE PROCEDURE suma (
    num1 IN NUMBER,
    num2 IN NUMBER
)IS
    resultado NUMBER;
BEGIN
    resultado := num1 + num2;
    dbms_output.put_line(num1 ||'+'||num2||'='||resultado);
END suma;

DECLARE
    num1 NUMBER DEFAULt 0;
    num2 NUMBER DEFAULT 0;
    resultado NUMBER;
BEGIN
    num1 := 1;
    num2 := 3;
    suma(num1, num2);
END;    

/*
Codificar un procedimiento que reciba una cadena y la visualice al revés.
*/
CREATE OR REPLACE PROCEDURE cadena_reves (
    cadena IN VARCHAR2
)
IS
    n_cadena VARCHAR2(100);
BEGIN
    for i in reverse 1..length(cadena) loop
        n_cadena := n_cadena || SUBSTR(n_cadena,i,1);
    end loop;
    dbms_output.put_line(n_cadena);
END cadena_reves;

DECLARE
    cadena VARCHAR2 (100) := 'Hola mundo';
BEGIN
    cadena_reves(cadena);
END;   


/*
Implementar un procedimiento que reciba un importe y visualice el desglose del
cambio en unidades monetarias de 1,2, 5, 10, 20, 50
en orden inverso al que aparecen aquí enumeradas.
*/

CREATE OR REPLACE PROCEDURE dev_cambio (
    dineros NUMBER
) IS
    cambio NATURAL := dineros;
    moneda NATURAL;
    v_uni_moneda NATURAL;
BEGIN
    DBMS_OUTPUT.PUT_LINE('***** DESGLOSE DE: ' || importe );
    WHILE cambio > 0 LOOP
        IF cambio >= 50 THEN
            moneda := 50;
        ELSIF cambio >= 20 THEN
            moneda := 20;
        ELSIF cambio >= 10 THEN
            moneda := 10;
        ELSIF cambio >= 5 THEN
            moneda := 5;
        ELSIF cambio >= 2 THEN
            moneda := 2;
        ELSe 
            moneda := 1; 
        END IF;
    v_uni_moneda := TRUNC(cambio / moneda);
    DBMS_OUTPUT.PUT_LINE(v_uni_moneda ||
    ' Unidades de: ' || moneda || ' Ptas. ');
    cambio := MOD(cambio, moneda);
    END LOOP;
END dev_cambio;

/*
Codificar un procedimiento que permita borrar un empleado cuyo número se
pasará en la llamada
*/
select * from empleado;
CREATE OR REPLACE PROCEDURE borrar_empleado (
    v_dni empleado.dni%TYPE
)IS
BEGIN
    DELETE FROM EMPLEADO WHERE dni = v_dni;
    dbms_output.put_line('Se ha borrado el empleado con dni '||v_dni);
END borrar_empleado;

begin
    borrar_empleado('