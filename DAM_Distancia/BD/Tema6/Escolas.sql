/*1- Declara un registro tipo_persona que admita los datos de una persona (dni, nombre
y apellidos). Después crea una variable p1 y dale un valor con tus datos mediante un
constructor. Muestra por pantalla tu nombre completo y el DNI con el siguiente formato:
Nombre Apellido1 Apellido2 (DNI).*/

SET SERVEROUTPUT ON

DECLARE
    TYPE persona IS RECORD(
        dni CHAR(9),
        nombre VARCHAR2(20),
        ape1 VARCHAR2(30),
        ape2 VARCHAR2(30)
    );
    p1 persona;
    
BEGIN
    p1 := persona('77010220X','Daniel','Martinez','Martinez');
     DBMS_OUTPUT.PUT_LINE(p1.nombre||' '||p1.ape1||' '||p1.ape2||' ('||p1.dni||').');
    
END;    


/*2. Crea un programa que imprima por pantalla la tabla de multiplicar de un numero n.
El número n debe estar declarado como variable y tener un valor de tu elección entre 1 y
10.*/

DECLARE
    numero number(2);
    otro number(2);
BEGIN
    otro := 5;
    for numero in 1..10 loop
        dbms_output.put_line(otro||'x'||numero||'='||otro*numero);
    end loop;    
END;

/*3.Crea un programa que dado un numero entero n determine si es primo o no. El
número n debe estar declarado como variable. Prueba con varios valores de n.*/

DECLARE
    numero number(2);
    divisores number := 0;
BEGIN
    numero := 15;
    for n in 1..numero loop
        if mod(numero,n) = 0 then
            divisores := divisores +1;
        end if;    
    end loop;    
    
    if divisores = 2 then 
        dbms_output.put_line('Es primo');
    else 
        dbms_output.put_line('No es primo');       
    end if;
END;


/*4. Crea un programa que imprima por pantalla cuantos alumnos deberían estar en
infantil, cuantos, en primaria y cuantos en secundaria a día de hoy. Ten en cuenta que en
los alumnos menores de 6 años van a infantil, los mayores de 12 van a secundaria y el
resto son de primaria. Para simplificar el problema contempla unicamente los alumnos
cuyo código (cod_alumno) esté entre 300 y 600.*/

DECLARE 
    n_infantil NUMBER := 0;
    n_primaria NUMBER := 0;
    n_secundaria NUMBER := 0;
    edad NUMBER;
    
    BEGIN
    FOR alumno IN (
        SELECT fecha_naci
        FROM alumno
        WHERE cod_alumno
        BETWEEN 300 and 600)
    LOOP
        edad := FLOOR(Months_Between(Sysdate, alumno.fecha_naci)/12);
        IF edad < 6 THEN
            n_infantil := n_infantil + 1;
        ELSIF    edad > 12 THEN
            n_secundaria := n_secundaria +1;
        ELSE 
            n_primaria := n_primaria +1;
        END IF;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Alumnos en Infantil: ' || n_infantil);
    DBMS_OUTPUT.PUT_LINE('Alumnos en Primaria: ' || n_primaria);
    DBMS_OUTPUT.PUT_LINE('Alumnos en Secundaria: ' || n_secundaria);
END;
