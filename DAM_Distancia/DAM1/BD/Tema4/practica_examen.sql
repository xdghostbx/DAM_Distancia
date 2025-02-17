-- 1 Obtener los nombres y salarios de los empleados con más de 1000 euros de 
--salario por orden alfabético.
SELECT nombre, ape1, ape2, salario
FROM empleado
WHERE salario > 1000
ORDER BY 2,1;

--Obtener el nombre de los empleados cuya comisión es superior al 20% de su salario
SELECT nombre, ape1, ape2
FROM empleado
WHERE (nvl(comision,0) > salario*0.2);
--nvl nos permite poner el 0 si la fila quie estamos verificando es nula

--Obtener el código de empleado, código de departamento, nombre y sueldo total en pesetas de aquellos empleados cuyo sueldo total (salario más comisión) supera los 1800 euros. Presentarlos ordenados por código de departamento y dentro de éstos por orden alfabético.
SELECT codemple, nombre, ape1, ape2, salario + comision AS SueldoTotal
FROM empleado
WHERE salario + comision > 1800
ORDER BY 1,3,2;

SELECT  nombre, ape1, ape2, salario
FROM empleado
WHERE salario > (
    SELECT salario * 1.05
    FROM empleado
    WHERE UPPER(ape1) LIKE 'JAZMIN' and UPPER(nombre) LIKE 'MARIA'
);

SELECT nombre, ape1, ape2, fechaIngreso, TRUNC(MONTHS_BETWEEN(SYSDATE,fechaingreso)/12, 0) AS antiguedad
FROM EMPLEADO
ORDER BY antiguedad;

-- 6 Obtener el nombre de los empleados que trabajan en un departamento con
--presupuesto superior a 50.000 euros. Hay que usar predicado cuantificado
SELECT nombre, ape1, ape2
FROM empleado
WHERE coddpto = SOME ( --ete some nos permite comparar todos los valores 
    SELECT coddpto
    FROM dpto
    WHERE presupuesto > 50000
);

-- 7 Obtener los nombres y apellidos de empleados que más cobran en la
--empresa.Considerar el salario más la comisión.
SELECT nombre, ape1, ape2, nvl(comision, 0) + salario AS salario_total
FROM empleado
WHERE nvl(comision, 0) + salario >= ALL ( --nos compara todos los valores y nos da el maximo
    SELECT nvl(comision, 0) + salario
    FROM empleado
)
ORDER BY
salario_total DESC;




--1. Obtén la calle, el número, y los metros cuadrados redondeados a un número entero inmediatamente superior para los garajes que tengan propietario.
SELECT calle, numero, CEIL(metros) as metros FROM hueco where tipo = 'GARAJE' and dni_propietario IS NOT NULL;

--2. Obtén todos los datos de las viviendas que se encuentren en números pares. Ordena el resultado descendentemente por calle y número.
SELECT calle, numero, codigopostal, nombrezona, tipovivienda, metrossolar FROM vivienda WHERE MOD(numero,2)=0 ORDER BY 1,2;

--3. Obtén un único campo llamado dirección_postal para todos los pisos de 4 habitaciones. La dirección postal debe tener el siguiente formato: “calle, numero, planta-puerta”. Ordena el resultado de forma ascendente.
SELECT CONCAT(calle,
                CONCAT(', ',
                        CONCAT(numero,
                            CONCAT(', ', 
                                CONCAT(planta, 
                                    CONCAT('-',puerta)))))) AS dideccion_postal
FROM piso WHERE numhabitaciones = 4 ORDER BY 1 ASC;
--Otra solución sería utilizando el operador ||
SELECT calle || ', ' || numero || ', ' || planta || '-' || puerta FROM piso WHERE numhabitaciones = 4 ORDER BY 1 ASC;

--4. Obtén el nombre y los 2 apellidos de todos los propietarios cuyo segundo apellido contenga una letra T (mayúscula o minúscula).
SELECT nombre, apellido1, apellido2 FROM propietario WHERE LOWER(apellido2) LIKE '%t%';
--Tambien se puede resolver con upper
SELECT nombre, apellido1, apellido2 FROM propietario WHERE UPPER(apellido2) LIKE '%T%';

--5. Obtén el nombre, appellidos e nombre_usuario, para todos los propietarios. El nombre usuario será todo en minúsculas y estará formado por la primera letra del nombre, las 2 primeras letras del primer apellido y las 2 primeras letras del segundo apellido. Por ejemplo, para el nombre Ana Alcalá López, el nombre_usuario sería aalló.
SELECT nombre, apellido1, apellido2,
LOWER(CONCAT(SUBSTR(nombre,1,1), CONCAT(SUBSTR(apellido1,1,2),SUBSTR(apellido2,1,2)))) AS nombre_usuario
FROM propietario;

--6. Obtén el nombre y apellidos para todos los propietarios. Para aquellos que tengan nombre o apellidos compuestos deben substituirse los espacios por ‘_’.
SELECT REPLACE(nombre, ' ','_') AS nombre, REPLACE(apellido1, ' ','_') AS apellido1, REPLACE(apellido2, ' ','_') AS apellido2 FROM propietario;

--7. Obtén la calle, el número, la planta, la puerta y la fecha actual para todos los trasteros que tengan propietario. El formato de la fecha debe ser: dia de la semana, dia-mes-año. Por ejemplo: Martes, 09-01-24.
SELECT calle, numero, planta, puerta, TO_CHAR(SYSDATE,'DAY ,DD-MM-YY') FROM hueco WHERE tipo = 'TRASTERO';

--8. Obtén el número de viviendas de la zona Centro.
SELECT COUNT(*) FROM vivienda WHERE nombrezona = 'Centro';

--9. Obtén el numero medio de habitaciones con una precisión de 2 decimales que tienen los pisos de la calle Alegria.
SELECT ROUND(AVG(numhabitaciones),2) AS num_medio_habitaciones FROM piso WHERE calle = 'Alegria';

--10. Obtén el total de metros dedicados a viviendas (solares) de la calle Damasco.
SELECT SUM(metrossolar) AS metros_viviendas FROM vivienda WHERE calle = 'Damasco';

--11. Realiza una consulta que devuelva cuantos metros tiene el garaje más grande disponible (sin propietario) de cada calle ordenados de forma descendiente por número de metros y calle
SELECT MAX(metros), calle FROM hueco WHERE dni_propietario IS NOT NULL GROUP BY calle ORDER BY 1 DESC,2 DESC;

--12.  Realiza una consulta que devuelva el número de pisos que tiene cada propietario (DNI_PROPIETARIO). Ordena el resultado por número de pisos de forma descendiente.
SELECT COUNT(*) AS num_pisos, dni_propietario FROM piso GROUP BY dni_propietario ORDER BY 1 DESC;

--13.Realiza una consulta que devuelva el DNI y la cantidad de pisos para los propietarios que tengan 2 o más pisos.
SELECT COUNT(*) AS num_pisos, dni_propietario FROM piso GROUP BY dni_propietario HAVING COUNT(*) >= 2;

--14. Obtén el número medio de pisos para aquellos bloques que no tienen ascensor
SELECT AVG(numpisos) FROM bloque WHERE ascensor = 'N';

--15. Obtén la cantidad de metros dedicados a cada tipo de hueco en cada edificio (entendiendo que un edificio está en un número y una calle).
SELECT calle, numero, tipo, SUM(metros) FROM hueco GROUP BY calle, numero, tipo ORDER BY 1, 2, 3;

--16. Obtén los pisos (calle, numero), planta y numero de puertas en esa planta para aquellos pisos que tengan más de 2 puertas en la segunda planta.
SELECT calle, numero, planta, COUNT(puerta) FROM piso  WHERE planta = 2 GROUP BY calle, numero, planta HAVING COUNT(puerta)>2;




--1. Obtén el nombre y apellidos de las personas que poseen una vivienda unifamiliar.
SELECT p.nombre, p.apellido1, p.apellido2
FROM propietario p
INNER JOIN casaparticular c ON p.dni = c.dni_propietario;   
--2. Haz una consulta que muestre la zona, número de parques, calle, número y metros de solar de las viviendas que se encuentran en una zona que posea más de un parque .
SELECT z.numparques, v.calle, v.numero, v.metrossolar
FROM zonaurbana z
INNER JOIN vivienda v ON z.nombrezona = v.nombrezona
WHERE z.numparques > 1;
--3. Haz una consulta que muestre para cada vivienda unifamiliar la calle, número, plantas, metros del solar y metros construidos.
SELECT c.calle, c.numero, c.num_plantas, v.metrossolar, c.metrosconstruidos
FROM casaparticular c
INNER JOIN vivienda v ON c.calle = v.calle AND c.numero=v.numero;

--4. Obtén el nombre y descripción de las zonas urbanas que tienen más de 2 parques donde se hayan construido bloques de pisos.
SELECT DISTINCT z.nombrezona, z.descripcion
FROM zonaurbana z
INNER JOIN vivienda v ON z.nombrezona = v.nombrezona
WHERE v.tipovivienda = 'Bloque' AND z.numparques > 2;
--4 Otra forma
SELECT nombrezona, descripcion
FROM zonaurbana
WHERE numparques > 2 AND nombrezona IN (
    SELECT nombrezona FROM vivienda WHERE tipovivienda = 'Bloque'
);
--5. Haz una consulta que muestre para cada piso la calle, número, planta, puerta, número de habitaciones, metros útiles, nombre de zona, número de parques existentes en la zona y nombre y apellidos del propietario.
SELECT p.calle, 
    p.numero, 
    p.planta, 
    p.puerta, 
    p.numhabitaciones, 
    p.metrosutiles, 
    z.nombrezona, 
    z.numparques, 
    pr.nombre, 
    pr.apellido1, 
    pr.apellido2
FROM piso p
INNER JOIN vivienda v ON p.calle = v.calle AND p.numero = v.numero
INNER JOIN zonaurbana z ON z.nombrezona = v.nombrezona
INNER JOIN propietario pr ON pr.dni = p.dni_propietario;

--6. Haz una consulta que muestre el nombre y apellidos de las mujeres que tienen bodegas de más de 9 metros cuadrados.
SELECT DISTINCT p.nombre, p.apellido1, p.apellido2
FROM hueco h
INNER JOIN propietario p ON h.dni_propietario = p.dni
WHERE h.tipo='BODEGA' AND h.metros > 9 AND p.sexo='M';

--7. Haz una consulta que devuelva DNI, nombre y apellidos de las mujeres que poseen una vivienda unifamiliar.
SELECT DISTINCT p.dni, p.nombre, p.apellido1, p.apellido2
FROM casaparticular c
INNER JOIN propietario p ON c.dni_propietario = p.dni
WHERE p.sexo='M';

--8. Haz una consulta que muestre los pisos (toda la información de la tabla piso) y el nombre completo de los propietarios que se encuentran en una zona con dos parques que tienen entre 2 y 4 habitaciones o que se encuentran en la zona Centro, con ascensor y que tienen más de 70 y menos de 110 metros cuadrados útiles.
SELECT p.*, pr.nombre, pr.apellido1, pr.apellido2
FROM piso p
INNER JOIN propietario pr ON p.dni_propietario = pr.dni
INNER JOIN bloque b ON b.calle = p.calle AND b.numero=p.numero 
INNER JOIN vivienda v ON v.calle = b.calle AND v.numero=b.numero
INNER JOIN zonaurbana z ON v.nombrezona=z.nombrezona
WHERE
(z.numparques=2 AND p.numhabitaciones BETWEEN 2 AND 4)
OR (z.nombrezona='Centro' AND b.ascensor='S' AND p.metrosutiles>70 AND p.metrosutiles<110);

--9. Haz una consulta que muestre el nombre en minúsculas y las viviendas unifamiliares de una planta, que poseen los hombres de los cuales tenemos teléfono.
SELECT lower(p.nombre), c.*
FROM propietario p
INNER JOIN casaparticular c ON p.dni = c.dni_propietario
WHERE p.sexo = 'H' AND p.telefono IS NOT NULL AND c.num_plantas=1;

--10. Haz una consulta que muestre las viviendas (calle, numero y tipovivienda) y la zona urbana en la que se encuentran (nombrezona y descripción).
SELECT v.calle, v.numero, v.tipovivienda, z.nombrezona, z.descripcion
FROM vivienda v
INNER JOIN zonaurbana z ON v.nombrezona = z.nombrezona;

--11. Obtén el nombre y los apellidos de todos los propietarios que además de piso tienen alguna casa.
SELECT DISTINCT pr.nombre, pr.apellido1, pr.apellido2
FROM piso p
INNER JOIN casaparticular c ON p.dni_propietario = c.dni_propietario
INNER JOIN propietario pr ON pr.dni = p.dni_propietario
;

--12. Haz una consulta que devuelva la siguiente información para todos los huecos del bloque situado en la calle Alegria, número 44.  Tipo de hueco, metros. En caso de que esté asociado a un piso mostrar el número de habitaciones y los metros construidos del piso asociado. Si el hueco no está asociado a ningún piso se devolverá ‘-’ para estos 2 campos.
SELECT h.tipo, h.metros, 
    CASE WHEN p.calle IS NULL THEN '-' ELSE TO_CHAR(p.numhabitaciones) END AS habitaciones,
    CASE WHEN p.calle IS NULL THEN '-' ELSE TO_CHAR(p.metrosconstruidos) END AS metros 
FROM hueco h
LEFT OUTER JOIN piso p ON h.calle = p.calle AND h.numero = p.numero AND p.planta = h.planta AND p.puerta = h.puerta
WHERE h.calle = 'Alegria' AND h.numero = 44;