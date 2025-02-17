/*
El codigo va dentro de un bloque. Un bloque PL/SQL empieza con la palabra
DECLARE

BEGIN
    y termina
END
*/

DECLARE (opcional)
    --declaramos las variables
    --declaramos constantes
    --declaramos cursores
BEGIN
    --consulatas a BBDD
    --intrucciones a realizar

EXCEPTION (opcional)
    --manejo de excepciones o errores

END; --declara el final de programa

--la unicas obligatorias serian BEGIN y END

-------------------------------------------------------------------------------------------
--VARIABLES: tienen que tener el mismo dominio que el que tiene la tabla para evitar errores
set SERVEROUTPUT on --comando para poder ver datos en la consola

DECLARE
    identificador integer := 50; --declaramos un integer con valor 50
    nombre varchar2(25) := 'Daniel Martinez'; --declaramos un integer
    apodo char(10) := 'dani';
    sueldo number(5) := 30000;
    comision decimal(4,2) := 50.20; --el 4 son digitos totales y el 2, digitos despues del punto
    fecha_actual date := (sysdate);
    fecha date := to_date ('09/07/2024','dd/mm/yyyy');
    saludo varchar2(50) default 'Buenos dias a todos'; --al tener default, siempre que se llame a saludo, asume ese valor por defecto
    verdadero boolean := true; 
    
BEGIN
    dbms_output.put_line('El valor de la variables es: ' || fecha); --paquete para ver en consola
END;

--CONSTANTES
/*
    Funcionan igual que las variables pero se le añade CONSTANT antes del tipo de variable
    La principal diferencia es que su valor no se modifica a lo largo del programa
*/
DECLARE
    mensaje constant varchar2(50) := 'Hola a todos';
BEGIN
END;

--CONDICIONALES
--Sentencia if
DECLARE 
    a number(2) := 10;
    b number(2) := 20;

BEGIN
    if a > b then
    dbms_output.put_line(a || ' es mayor que '|| b);
    else
    dbms_output.put_line(b || ' es mayor que '|| a);
    end if;
END; 

--otro ejemplo con elsif
DECLARE
    numero number(3) := 100;
    
BEGIN
    if(numero = 10) then
    dbms_output.put_line('El valor del numero es 10');
    elsif (numero = 20) then
    dbms_output.put_line('El valor del numero es 20');
    elsif (numero = 30) then
    dbms_output.put_line('El valor del numero es 30');
    else 
    dbms_output.put_line('no se encontro el valor del numero');
    end if;
END;  

--BUCLES
/*
loop basico
    loop
        secuencia de instrucciones;
    fin del loop; 
while loop
    while condicion loop
        secuencia de intrucciones;
    fin del loop;    
for
    for contador in valor1..valor2 loop
        secuencia de intrucciones;
    fin del loop;    
bucles anidados
    loop principal
        primera sentencia
        loop anidado
            segunda secuencia
        fin del bucle anidado
    fin del bucle principal
*/    
--Ejemplos de loops basicos
DECLARE
    numero number := 10;
BEGIN
    loop
        dbms_output.put_line(numero);
        numero := numero + 10;
        if numero >= 50 then
            exit;--termina el bucle
        end if;
    end loop;
    dbms_output.put_line('El valor final del numero es: ' || numero);
END; 


DECLARE
    numero number := 10;
BEGIN
    loop
        dbms_output.put_line(numero);
        numero := numero + 10;
        exit when numero >= 50;  --para ahorrarnos un if
    end loop;
    dbms_output.put_line('El valor final del numero es: ' || numero);
END; 
--ejemplos de bucle while

DECLARE
    valor number(2) := 10;
BEGIN
    while valor < 20 loop
      dbms_output.put_line('El valor es '|| valor); 
      valor := valor + 1;
    end loop;  
END;

DECLARE
    valor number(2) := 0;
    resultado number;
BEGIN
    while valor <= 10 loop
        resultado := 3*valor;
        dbms_output.put_line('3x'|| valor||'='||resultado); 
        valor := valor + 1;
    end loop;  
END;

--ejemplos de bucle for
DECLARE
    numero number(2);
BEGIN
    for numero in 10..20 loop
        dbms_output.put_line(numero);
    end loop;    
END;

BEGIN
    for f in reverse 0..5 loop
        dbms_output.put_line(f);
    end loop;    
END;

BEGIN
    for f in  1..10 loop
        dbms_output.put_line('3x'||f||'='||(f*3));
    end loop;    
END;

--ejemplos de bucles anidados
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--STRINGS
DECLARE
    nombre varchar2(20);
    direccion varchar2(30);
    detalles clob;
    eleccion char(1);
    
BEGIN
    nombre := 'Daniel Martinez';
    direccion := 'Calle num 1';
    detalles := 'Este es el detalles de la variable clon que iniciamos en la
    seccion declarativa, es una variable de gran alamacenamiento';
    eleccion:= 'y';
    if eleccion = 'y' then
        dbms_output.put_line('Mi nombre es '||nombre);
        dbms_output.put_line('Mi direccion es '||direccion);
        dbms_output.put_line(detalles);
    end if;
END;    

--funciones internas de pl/sql para trabajar con string

DECLARE
    saludo varchar2(50) := 'Hola que tal';
    
BEGIN
    dbms_output.put_line(UPPER(saludo));
    dbms_output.put_line(LOWER(saludo));
    dbms_output.put_line(INITCAP(saludo));--mayus la primera letra de cada palabra
    dbms_output.put_line(SUBSTR(saludo,1,4));
    dbms_output.put_line(INSTR(saludo,'a'));--nos da la posicion de la letra
END;

DECLARE
    saludo varchar2(50) := '####Hola que tal####';
    
BEGIN
    dbms_output.put_line(RTRIM(saludo,'#'));
    dbms_output.put_line(LTRIM(saludo,'#'));
    dbms_output.put_line(TRIM('#' from saludo));
END;