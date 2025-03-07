USE instituto;

declare @count int = 0;

select @count =  COUNT(*) FROM profesor;
if(@count=0)
BEGIN
		INSERT INTO profesor (  nombre ,  ape1 ,  ape2 ,  tipoFuncionario ) VALUES
		( 'Juan', 'Perez', 'García', NULL),
		( 'Carlos', 'González', 'Oltra', NULL),
		( 'Sergio', 'Mateo', 'Ramis', NULL),
		( 'Paco', 'Moreno', 'Díaz', NULL),
		( 'Ana', 'Morales', 'Ortega', NULL),
		( 'Marcos', 'Tortosa', 'Martínez', NULL),
		( 'Sara', 'Barrrera', 'Salas', NULL),
		( 'Raquel', 'Peqrez', 'Izquierdo', NULL),
		( 'Rosa', 'Díaz', 'Del Toro', NULL),
		( 'Laura', 'Vivó', 'López', NULL),
		( 'Emilio', 'Perez', 'García', NULL),
		( 'Alfredo', 'González', 'Oltra', NULL),
		( 'Eduardo', 'Grau', 'Aroca', NULL),
		( 'Pau', 'Ayala', 'Fuentes', NULL),
		( 'Gabriel', 'Sáez', 'Izquierdo', NULL),
		( 'Javier', 'Ramírez', 'Olmo', NULL),
		( 'Elias', 'Rubio', 'Sánchez', '0'),
		( 'Juan Manuel', 'Campos', 'Alierta', '1'),
		( 'Anabel', 'Marco', 'Izquierdo', '2'),
		( 'Ricardo', 'Acosta', 'Soler', '0'),
		( 'Laura', 'Vallés', 'Muñoz', '1'),
		( 'Elisa', 'Amador', 'Serra', '2');
END

select @count =  COUNT(*) FROM cicloformativo;
if(@count=0)
BEGIN
	INSERT INTO cicloformativo (   nombreCiclo ,  horas ) VALUES
	( 'DAM', 1890),
	( 'DAW', 1900);
END

select @count =  COUNT(*) FROM tiposbasicos;
if(@count=0)
BEGIN
	INSERT INTO tiposbasicos ( inte ,  bigint1 ,   smallint1 ,
	float1 ,  character1 ,  byte1 ,
	bit1 ,   stri ,  dateDate ,
	timeTime ,  [dateTime2] ,  texto ,
	binario ,  bigDecimal ) VALUES
	(1, 12, 13,
	14.1,  'W',16,
	1, 'Hola mundo','2022-01-23', 
	'18:36:07', '2022-01-23 18:36:07', 'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo',
	0x45f53a67ff, 5345345324532.00),
	(2, 12, 13,
	14.1,'W',16, 
	0,  'Hola mundo','2022-01-23',
	'18:36:07', '2022-01-23 18:36:07', 'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo', 
	0x45f53a67ff, 5345345324532.00),
	(3, 12, 13, 
	 15.2, 'W', 16,
	 1,  'Hola mundo', '2022-01-23',
	 '18:40:06', '2022-01-23 18:40:06', 'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo', 
	 0x45f53a67ff,  5345345324532.00),
	(4, 12, 13,
	15.2, 'W', 16,
	0,  'Hola mundo', '2022-01-23',
	'18:40:06', '2022-01-23 18:40:06',
	'texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo',
	0x45f53a67ff, 5345345324532.00);


END
