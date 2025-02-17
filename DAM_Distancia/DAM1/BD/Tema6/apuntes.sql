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
    --logica de programacion
END;

/*
Su uso mejora el rendimiento. Con PL/SQL en el ejemplo siguiente (comparando con SQL)
tan solo hace una llamada a la BBDD, haciendo que el trafico de red sea menor
*/

--SQL
--Consulta1:
SELECT * FROM TABLA1;
--Consulta2:
INSERT INTO TABLE VALUE(valores);

--PL/SQL
DECLARE

BEGIN   
    Consulta1
    Consulta2
END;

/*
En el caso de SQL hacemos 2 llamas al servidor. O una llamada por consulta
Con PL/SQL podemos insertar todas las consultas dentro de una sola llamada
*/

