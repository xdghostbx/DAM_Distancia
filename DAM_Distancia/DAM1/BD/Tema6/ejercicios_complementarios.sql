SET SERVEROUTPUT ON;
/*
1-
Declara un registro tipo_persona que admita los datos de una persona (dni, nombre
y apellidos). Después crea una variable p1 y dale un valor con tus datos mediante un
constructor. Muestra por pantalla tu nombre completo y el DNI con el siguiente formato:
Nombre Apellido1 Apellido2 (DNI).
*/

DECLARE
    -- Definición del tipo de registro
    TYPE tipo_persona IS RECORD(
        dni VARCHAR2(10),
        nombre VARCHAR2(50),
        apellido1 VARCHAR2(50),
        apellido2 VARCHAR2(50)
    );

    -- Declaración de una variable del tipo de registro
    p1 tipo_persona;

BEGIN
    -- Asignar valores a los campos del registro
    p1.dni := '1234567X';
    p1.nombre := 'Daniel';
    p1.apellido1 := 'Martinez';
    p1.apellido2 := p1.apellido1;

    -- Imprimir los valores del registro
    DBMS_OUTPUT.PUT_LINE(p1.nombre || ' ' || p1.apellido1 || ' ' || p1.apellido2 || ' (' || p1.dni || ')');
END;   


/*
2-
Crea un programa que imprima por pantalla la tabla de multiplicar de un numero n.
El número n debe estar declarado como variable y tener un valor de tu elección entre 1 y
10
*/

DECLARE
    n NUMBER := 5;
BEGIN
    for i in 1..10 LOOP
        DBMS_OUTPUT.PUT_LINE(n || 'x' || i ||' = '||n*i);   
    end loop;
END;    


/*
3-
Crea un programa que dado un numero entero n determine si es primo o no. El
número n debe estar declarado como variable. Prueba con varios valores de n
*/



/*
4-
Crea un programa que imprima por pantalla cuantos alumnos deberían estar en
infantil, cuantos, en primaria y cuantos en secundaria a día de hoy. Ten en cuenta que en
los alumnos menores de 6 años van a infantil, los mayores de 12 van a secundaria y el
resto son de primaria. Para simplificar el problema contempla unicamente los alumnos
cuyo código (cod_alumno) esté entre 300 y 600
*/

--tengo que seleccionar todos los alumnos de cod entre 300 y 600
--crear variables locales de primaria, infantil y secundaria
--de la tabla alumnos un months between de su fecha con la sysdate
-- si edad < 6 infantil
-- si edad > 12 secundaria
-- else primaria


DECLARE
    CURSOR colocar_alumnos IS
        SELECT cod_alumno, fecha_naci FROM alumno WHERE cod_alumno BETWEEN 300 AND 600;
        
    v_codigo alumno.cod_alumno%TYPE;
    v_fecha alumno.fecha_naci%TYPE;
    primaria NUMBER := 0;
    secundaria NUMBER := 0;
    infantil NUMBER := 0;


BEGIN
    OPEN colocar_alumnos;
    LOOP
        FETCH colocar_alumnos INTO v_codigo, v_fecha;
        EXIT WHEN colocar_alumnos%NOTFOUND;
        
        IF ((MONTHS_BETWEEN(SYSDATE,v_fecha)/12)<6) THEN
            infantil := infantil +1;
        ELSIF ((MONTHS_BETWEEN(SYSDATE,v_fecha)/12)>12) THEN
            secundaria := secundaria +1;
        ELSE 
            primaria := primaria +1;
        END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Alumnos en infantil : '||infantil);
    DBMS_OUTPUT.PUT_LINE('Alumnos en primaria : '||primaria);
    DBMS_OUTPUT.PUT_LINE('Alumnos en secundaria : '||secundaria);
END;   


/*
5-
Modifica el ejercicio 4 para almacenar al alumnado en el array infantil, primaria o
secundaria en función de su edad. Al finalizar muestra el el nombre y apellidos del
alumnado de cada uno de los arrays de la siguiente forma:
Alumnado de infantíl:
NombreX Apellido1X Apellido2Y
*/

DECLARE
    TYPE array IS TABLE OF VARCHAR2(200);
    array_infantil array := array();
    array_primaria array := array();
    array_secundaria array := array();
    
    CURSOR colocar_alumnos IS
        SELECT nombre, apellido1, apellido2, fecha_naci FROM alumno WHERE cod_alumno BETWEEN 300 AND 600;
        
    v_nombre alumno.nombre%TYPE;
    v_ap1 alumno.apellido1%TYPE;
    v_ap2 alumno.apellido2%TYPE;
    v_fecha alumno.fecha_naci%TYPE;
    primaria NUMBER(3) := 0;
    secundaria NUMBER(3) := 0;
    infantil NUMBER(3) := 0;
    nombreCompleto VARCHAR2(200);
    edad NUMBER;

BEGIN
    OPEN colocar_alumnos;
    LOOP
        FETCH colocar_alumnos INTO v_nombre, v_ap1, v_ap2, v_fecha;
        EXIT WHEN colocar_alumnos%NOTFOUND;
        
        nombreCompleto := v_nombre || ' ' || v_ap1 || ' ' || v_ap2;
        edad := ABS(TRUNC(MONTHS_BETWEEN(SYSDATE, v_fecha))) / 12;
        
        IF edad < 6 THEN
            infantil := infantil + 1;
            array_infantil.EXTEND;
            array_infantil(array_infantil.LAST) := nombreCompleto;
        ELSIF edad >= 6 AND edad <= 12 THEN
            primaria := primaria + 1;
            array_primaria.EXTEND;
            array_primaria(array_primaria.LAST) := nombreCompleto;
        ELSE
            secundaria := secundaria + 1;
            array_secundaria.EXTEND;
            array_secundaria(array_secundaria.LAST) := nombreCompleto;
        END IF;
    END LOOP;
    CLOSE colocar_alumnos;
    
    DBMS_OUTPUT.PUT_LINE('Alumnos en infantil: ' || infantil);
    DBMS_OUTPUT.PUT_LINE('Alumnos en primaria: ' || primaria);
    DBMS_OUTPUT.PUT_LINE('Alumnos en secundaria: ' || secundaria);
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('Alumnado de Infantil: ');
    IF array_infantil.COUNT > 0 THEN
        FOR i IN 1..array_infantil.COUNT LOOP
            DBMS_OUTPUT.PUT_LINE(array_infantil(i));
        END LOOP;
    ELSE
        DBMS_OUTPUT.PUT_LINE('No hay alumnos en Infantil.');
    END IF;
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('Alumnado de Primaria: ');
    IF array_primaria.COUNT > 0 THEN
        FOR i IN 1..array_primaria.COUNT LOOP
            DBMS_OUTPUT.PUT_LINE(array_primaria(i));
        END LOOP;
    ELSE
        DBMS_OUTPUT.PUT_LINE('No hay alumnos en Primaria.');
    END IF;
    DBMS_OUTPUT.PUT_LINE(' ');
    DBMS_OUTPUT.PUT_LINE('Alumnado de Secundaria: ');
    IF array_secundaria.COUNT > 0 THEN
        FOR i IN 1..array_secundaria.COUNT LOOP
            DBMS_OUTPUT.PUT_LINE(array_secundaria(i));
        END LOOP;
    ELSE
        DBMS_OUTPUT.PUT_LINE('No hay alumnos en Secundaria.');
    END IF;
    
END;


CREATE OR REPLACE PROCEDURE cambio_localidad(
    v_localidad IN VARCHAR2, --varchar porque no existe la localidad en mi bbdd
    v_num_departamento IN NUMBER --lo mismo
)IS

BEGIN
    update departamento
    set localidad = v_localidad
    where num_departamento = v_num_departamento;
    --imprimir a consola la actualizacion para depurar tal vez
END cambio_localidad;

/*Visualizar todos los procedimientos y funciones del usuario almacenados en la base
de datos y su situación (valid o invalid)*/
SELECT OBJECT_NAME, OBJECT_TYPE, STATUS
FROM USER_OBJECTS
WHERE OBJECT_TYPE IN ('PROCEDURE','FUNCTION');


/*
Desarrollar un procedimiento que visualice el apellido y la fecha de alta de todos los
empleados ordenados por apellido
*/

CREATE OR REPLACE PROCEDURE ordenar_empleados
IS
    CURSOR c_empleado IS
        SELECT nombre, anio_incorporacion
        FROM empleado
        ORDER BY anio_incorporacion;
        
        v_nombre empleado.nombre%TYPE;
        v_anio empleado.anio_incorporacion%TYPE;
BEGIN
    OPEN c_empleado;
        FETCH c_empleado INTO v_nombre, v_anio;
        WHILE c_empleado%FOUND LOOP
            dbms_output.put_line(v_nombre||' '||v_anio);
        END LOOP;
    CLOSE c_empleado;
END ordenar_empleados;   

/*
Codificar un procedimiento que muestre el nombre de cada departamento y los
 empleados que tiene
 
 hacer un segundo con el numero de empleados por departamento
*/
SET SERVEROUTPUT ON;
DECLARE
    CURSOR empleados_departamento IS
        select nombre,puesto
        FROM empleado e
        inner join tipos_puesto p on e.id_puesto = p.id_puesto;
        
        
        v_nombre empleado.nombre%TYPE;
        v_puesto tipos_puesto.puesto%TYPE;
BEGIN        
    OPEN empleados_departamento;
        FETCH empleados_departamento INTO v_nombre,v_puesto;
        WHILE empleados_departamento%FOUND LOOP
            dbms_output.put_line(v_nombre||' '||v_puesto);
            FETCH empleados_departamento INTO v_nombre,v_puesto;
        END LOOP;
    CLOSE empleados_departamento;
END;   

--empleados por departamento
DECLARE
    CURSOR empleados_departamento IS
        select puesto, count(dni)
        from tipos_puesto e
        inner join empleado p on e.id_puesto = p.id_puesto
        group by puesto;
        
        
        v_numEmpleados NUMBER default 0;
        v_puesto tipos_puesto.puesto%TYPE;
BEGIN        
    OPEN empleados_departamento;
            FETCH empleados_departamento INTO v_puesto,v_numEmpleados;
            WHILE empleados_departamento%FOUND LOOP
                dbms_output.put_line(v_numEmpleados||' '||v_puesto);
                FETCH empleados_departamento INTO v_puesto,v_numEmpleados;
            END LOOP;
    CLOSE empleados_departamento;
END;
DECLARE
    CURSOR empleados_departamento IS
        select puesto, count(dni)
        from tipos_puesto e
        inner join empleado p on e.id_puesto = p.id_puesto
        group by puesto;
        
        
        v_numEmpleados NUMBER default 0;
        v_puesto tipos_puesto.puesto%TYPE;
BEGIN        
    OPEN empleados_departamento;
        LOOP
            FETCH empleados_departamento INTO v_puesto,v_numEmpleados;
            EXIT WHEN empleados_departamento%NOTFOUND;
            dbms_output.put_line(v_numEmpleados||' '||v_puesto);
            END LOOP;
    CLOSE empleados_departamento;
END;


