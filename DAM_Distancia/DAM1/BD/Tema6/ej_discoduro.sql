/*
1. Crea una función a la que le pasaremos como parámetros de entrada: MATRICULA, NUEVO_PRECIO_COMPRA. la función modificara los datos del coche que tenga la matricula introducida actualizando el precio_compra de la siguiente forma:

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






CREATE OR REPLACE TYPE Alumno AS OBJECT (
  cod_alumno NUMBER,
  nombre VARCHAR2(100),
  apellidos VARCHAR2(100),
  fecha_naci DATE,
  sexo CHAR(1)
  MAP MEMBER FUNCTION get_codigo RETURN NUMBER
);

CREATE OR REPLACE TYPE BODY Alumno IS
  MAP MEMBER FUNCTION get_codigo RETURN NUMBER IS
  BEGIN
    RETURN cod_alumno;
  END get_codigo;
END;

DECLARE
  TYPE t_alumno IS TABLE OF Alumno INDEX BY BINARY_INTEGER;
  empleados t_empleado_tab;


  alumnos(1) := Alumno(101, 'Juan', 'Pérez', TO_DATE('1995-03-24', 'YYYY-MM-DD'), 'M');
  alumnos(2) := Alumno(102, 'María', 'López', TO_DATE('1996-07-15', 'YYYY-MM-DD'), 'F');
  alumnos(3) := Alumno(103, 'Carlos', 'García', TO_DATE('1997-11-02', 'YYYY-MM-DD'), 'M');

  
  FOR i IN 1 .. alumnos.COUNT LOOP
    DBMS_OUTPUT.PUT_LINE('Alumno ' || alumnos(i).cod_alumno || ': ' || alumnos(i).nombre ||
     ' ' || alumnos(i).apellidos);
  END LOOP;
END;
/