-- Switch to the 'instituto' database
USE instituto;

-- Insert data into 'profesor' table if it is empty
INSERT INTO profesor (nombre, ape1, ape2, tipoFuncionario)
SELECT nombre, ape1, ape2, tipoFuncionario
FROM (
    SELECT 'Juan' AS nombre, 'Perez' AS ape1, 'García' AS ape2, NULL AS tipoFuncionario UNION ALL
    SELECT 'Carlos', 'González', 'Oltra', NULL UNION ALL
    SELECT 'Sergio', 'Mateo', 'Ramis', NULL UNION ALL
    SELECT 'Paco', 'Moreno', 'Díaz', NULL UNION ALL
    SELECT 'Ana', 'Morales', 'Ortega', NULL UNION ALL
    SELECT 'Marcos', 'Tortosa', 'Martínez', NULL UNION ALL
    SELECT 'Sara', 'Barrrera', 'Salas', NULL UNION ALL
    SELECT 'Raquel', 'Peqrez', 'Izquierdo', NULL UNION ALL
    SELECT 'Rosa', 'Díaz', 'Del Toro', NULL UNION ALL
    SELECT 'Laura', 'Vivó', 'López', NULL UNION ALL
    SELECT 'Emilio', 'Perez', 'García', NULL UNION ALL
    SELECT 'Alfredo', 'González', 'Oltra', NULL UNION ALL
    SELECT 'Eduardo', 'Grau', 'Aroca', NULL UNION ALL
    SELECT 'Pau', 'Ayala', 'Fuentes', NULL UNION ALL
    SELECT 'Gabriel', 'Sáez', 'Izquierdo', NULL UNION ALL
    SELECT 'Javier', 'Ramírez', 'Olmo', NULL UNION ALL
    SELECT 'Elias', 'Rubio', 'Sánchez', '0' UNION ALL
    SELECT 'Juan Manuel', 'Campos', 'Alierta', '1' UNION ALL
    SELECT 'Anabel', 'Marco', 'Izquierdo', '2' UNION ALL
    SELECT 'Ricardo', 'Acosta', 'Soler', '0' UNION ALL
    SELECT 'Laura', 'Vallés', 'Muñoz', '1' UNION ALL
    SELECT 'Elisa', 'Amador', 'Serra', '2'
) AS temp
WHERE NOT EXISTS (SELECT 1 FROM profesor);

-- Insert data into 'cicloformativo' table if it is empty
INSERT INTO cicloformativo (nombreCiclo, horas)
SELECT nombreCiclo, horas
FROM (
    SELECT 'DAM' AS nombreCiclo, 1890 AS horas UNION ALL
    SELECT 'DAW', 1900
) AS temp
WHERE NOT EXISTS (SELECT 1 FROM cicloformativo);

-- Insert data into 'tiposbasicos' table if it is empty
INSERT INTO tiposbasicos (inte, bigint1, smallint1, float1, character1, byte1, bit1, stri, dateDate, timeTime, dateTime2, texto, binario, bigDecimal)
SELECT 1, 12, 13, 14.1, 'W', 16, 1, 'Hola mundo', '2022-01-23', '18:36:07', '2022-01-23 18:36:07', 
       'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo',
       0x45f53a67ff, 5345345324532.00
WHERE NOT EXISTS (SELECT 1 FROM tiposbasicos WHERE inte = 1 AND bigint1 = 12);

INSERT INTO tiposbasicos (inte, bigint1, smallint1, float1, character1, byte1, bit1, stri, dateDate, timeTime, dateTime2, texto, binario, bigDecimal)
SELECT 2, 12, 13, 14.1, 'W', 16, 0, 'Hola mundo', '2022-01-23', '18:36:07', '2022-01-23 18:36:07', 
       'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo',
       0x45f53a67ff, 5345345324532.00
WHERE NOT EXISTS (SELECT 1 FROM tiposbasicos WHERE inte = 2 AND bigint1 = 12);

INSERT INTO tiposbasicos (inte, bigint1, smallint1, float1, character1, byte1, bit1, stri, dateDate, timeTime, dateTime2, texto, binario, bigDecimal)
SELECT 3, 12, 13, 15.2, 'W', 16, 1, 'Hola mundo', '2022-01-23', '18:40:06', '2022-01-23 18:40:06', 
       'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo',
       0x45f53a67ff, 5345345324532.00
WHERE NOT EXISTS (SELECT 1 FROM tiposbasicos WHERE inte = 3 AND bigint1 = 12);

INSERT INTO tiposbasicos (inte, bigint1, smallint1, float1, character1, byte1, bit1, stri, dateDate, timeTime, dateTime2, texto, binario, bigDecimal)
SELECT 4, 12, 13, 15.2, 'W', 16, 0, 'Hola mundo', '2022-01-23', '18:40:06', '2022-01-23 18:40:06',
       'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo',
       0x45f53a67ff, 5345345324532.00
WHERE NOT EXISTS (SELECT 1 FROM tiposbasicos WHERE inte = 4 AND bigint1 = 12);
