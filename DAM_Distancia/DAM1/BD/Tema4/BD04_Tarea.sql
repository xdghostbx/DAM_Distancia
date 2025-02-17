-- 1 Obtener los nombres y salarios de los empleados con m�s de 1000 euros de salario por orden alfab�tico.
SELECCT nombre, ape1, ape2, salario FROM empleado
WHERE salario > 1000 ORDER BY ape1, nombre;

-- 2 Obtener el nombre de los empleados cuya comisi�n es superior al 20% de su salario.
SELECT nombre, ape1, ape2, comision, salario FROM empleado
WHERE comision > 200 * salario;

-- 3 Obtener el c�digo de empleado, c�digo de departamento, nombre y sueldo total en pesetas de aquellos
-- empleados cuyo sueldo total (salario + comision) supera los 1800euros. Presentarlos ordenados por su
-- c�digo de departamento y dentro de estos, por orden alfab�tico
SELECT codemple, coddpto, nombre, ape1, ape2, (salario+nvl(comision,0))*166.386 AS sueldopts
FROM empleado WHERE salario+nvl(comision,0)>1800
ORDER BY coddpto,ape1,ape2,nombre;

-- 4 Obtener por orden alfab�tico los nombres de empleados cuyo salario igualen o superen en 
-- m�s de un 5% al salario de la empleada �MARIA JAZMIN�
SELECT nombre, ape1, salario FROM empleado
WHERE salario >= (SELECT salario * 1.05 FROM empleado
WHERE ape1='JAZMIN' and nombre='MARIA')
ORDER BY ape1, nombre;

-- 5 Obtener una listado ordenado por a�os en la empresa con los nombres, y apellidos de 
-- los empleados y los a�os de antig�edad en la empresa
SELECT nombre,ape1,ape2, months_between(sysdate,fechaingreso)/12 AS antiguedad 
FROM empleado 
ORDER BY antiguedad;

-- 6 Obtener el nombre de los empleados que trabajan en un departamento con presupuesto superior 
-- a 50.000 euros. Hay que usar predicado cuantificado
SELECT nombre, ape1, ape2 FROM empleado 
WHERE coddpto=SOME(SELECT coddpto FROM dpto WHERE presupuesto>50000);

-- 7 Obtener los nombres y apellidos de empleados que m�s cobran en la empresa.Considerar el salario m�s la comisi�n.

SELECT nombre, ape1, ape2, nvl(comision,0)+salario AS salario_total FROM empleado 
WHERE nvl(comision,0)+salario > =ALL(SELECT nvl(comision,0)+salario FROM empleado)
ORDER BY salario_total DESC;

-- 8 Obtener en orden alfab�tico los nombres de empleado cuyo salario es inferior al m�nimo de los empleados del departamento 1.
SELECT nombre,ape1, ape2 ,salario FROM empleado 
WHERE salario < ALL(SELECT salario FROM empleado WHERE coddpto=1) 
ORDER BY ape1, ape2, nombre;

-- 9 Obtener los nombre de empleados que trabajan en el departamento del cu�l es jefe el empleado con c�digo 1.
SELECT nombre,ape1, ape2 FROM empleado 
WHERE coddpto IN (SELECT coddpto FROM dpto WHERE codemplejefe=1);

-- 10 Obtener los nombres de los empleados cuyo primer apellido empiece por las letras p, q, r, s.
SELECT nombre, ape1, ape2 FROM empleado
WHERE substr(ape1, 1 ,1) IN ('P', 'Q','R','S')
ORDER BY ape1, ape2, nombre;

-- 11 Obtener los empleados cuyo nombre de pila contenga el nombre JUAN.
SELECT nombre, ape1, ape2 FROM empleado
WHERE nombre LIKE '%JUAN%'
ORDER BY nombre, ape1, ape2;

-- 12 Obtener los nombres de los empleados que viven en ciudades en las que hay alg�n centro de trabajo
SELECT nombre, ape1, ape2 FROM empleado
WHERE upper(localidad) IN (SELECT upper(localidad)
FROM centro;

-- 13 Obtener el nombre del jefe de departamento que tiene mayor salario de entre los jefes de departamento.
SELECT nombre,ape1, ape2 FROM empleado 
WHERE codemple IN (SELECT codemplejefe FROM dpto) AND 
salario =  (SELECT Max(salario) FROM empleado WHERE codemple IN (SELECT codemplejefe FROM dpto));

-- 14 Obtener en orden alfab�tico los salarios y nombres de los empleados cuyo
-- salario sea superior al 60% del m�ximo salario de la empresa.
SELECT nombre, ape1, ape2, salario FROM empleado
WHERE salario >0.6 * (SELECT max(salario) FROM empleado)
ORDER BY ape1, ape2, nombre;

-- 15 Obtener en cu�ntas ciudades distintas viven los empleados.
SELECT count(DISTINCT localidad) FROM empleado;

-- 16 El nombre y apellidos del empleado que m�s salario cobra
SELECT nombre,ape1,ape2, salario FROM empleado 
WHERE salario=(SELECT MAX(salario) FROM empleado);

-- 17 Obtener las localidades y n�mero de empleados de aquellas en las que viven m�s de 3 empleados
SELECT localidad,COUNT(*) FROM empleado
GROUP BY localidad having count(*) > 3
ORDER BY localidad;

-- 18 Obtener para cada departamento cu�ntos empleados trabajan, la suma de sus salarios y la suma de sus
-- comisiones para aquellos dep artamen to en los que hay alg�n empleado cuyo salario es superior a 1700 euros.
SELECT coddpto, sum(salario) AS salarioTotal, sum(nvl(comision,0)) AS comisionTotal, COUNT(codemple) AS numEmpleados 
FROM empleado 
WHERE coddpto in (select distinct coddpto FROM empleado WHERE salario>1700)
GROUP BY coddpto;

-- 19 Obtener el departamento que m�s empleados tiene
SELECT denominacion FROM dpto,empleado 
WHERE empleado.coddpto=dpto.coddpto 
GROUP BY dpto.coddpto,denominacion 
having count(empleado.codemple)>=all(select count(codemple) from empleado group by coddpto);

-- 20 Obtener los nombres de todos los centros y los departamentos que se ubican 
-- en cada uno,as� como aquellos centros que no tienen departamentos.

-- 21 Obtener el nombre del departamento de m�s alto nivel, es decir, aquel que no depende de ning�n otro.

-- 22 Obtener todos los departamentos existentes en la empresa y los empleados (si los tiene) que pertenecen a �l.

-- 23 Obtener un listado en el que aparezcan todos los departamentos existentes y el departamento del cual 
-- depende,si depende de alguno.

-- 24 Obtener un listado ordenado alfab�ticamente donde aparezcan los nombres de los empleados y a continuaci�n 
-- el literal "tiene comisi�n" si la tiene,y "no tiene comisi�n" si no la tiene.

-- 25 Obtener un listado de las localidades en las que hay centros y no vive ning�n empleado ordenado alfab�ticamente.

-- 26 Obtener un listado de las localidades en las que hay centros y adem�s vive al menos un empleado ordenado alfab�ticamente.

-- 27 Esta cuesti�n punt�a por 2. Se desea dar una gratificaci�n por navidades en funci�n de la antig�edad en la empresa siguiendo estas pautas:
--    -Si lleva entre 1 y 5 a�os, se le dar� 100 euros
--    -Si lleva entre 6 y 10 a�os, se le dar� 50 euros por a�o
--    -Si lleva entre 11 y 20 a�os, se le dar� 70 euros por a�o
--    -Si lleva m�s de 21 a�os, se le dar� 100 euros por a�o

-- 28 Obtener un listado de los empleados,ordenado alfab�ticamente,indicando cu�nto le corresponde de 
-- gratificaci�n

-- 29 Obtener a los nombres, apellidos de los empleados que no son jefes de departamento.


