USE [instituto]
GO



IF ((SELECT COUNT(*) FROM [dbo].[comunidadAutonoma]) =0)
BEGIN
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (1, N'Andalucía')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (2, N'Aragón')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (3, N'Asturias, Principado de')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (4, N'Illes Balears')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (5, N'Canarias')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (6, N'Cantabria')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (7, N'Castilla y León')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (8, N'Castilla - La Mancha')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (9, N'Cataluña')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (10, N'Comunitat Valenciana')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (11, N'Extremadura')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (12, N'Galicia')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (13, N'Comunidad de Madrid')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (14, N'Región de Murcia')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (15, N'Comunidad Foral de Navarra')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (16, N'País Vasco')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (17, N'Rioja, La')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (18, N'Ceuta')
	INSERT [dbo].[comunidadAutonoma] ([idCA], [nombre]) VALUES (19, N'Melilla')
END
IF ((SELECT COUNT(*) FROM [dbo].[provincia]) =0)
BEGIN
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (1, N'Araba', 16)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (2, N'Albacete', 8)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (3, N'Alacant', 10)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (4, N'Almería', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (5, N'Ávila', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (6, N'Badajoz', 11)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (7, N'Illes Balears', 4)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (8, N'Barcelona', 9)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (9, N'Burgos', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (10, N'Cáceres', 11)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (11, N'Cádiz', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (12, N'Castelló', 10)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (13, N'Ciudad Real', 8)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (14, N'Córdoba', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (15, N'A Coruña', 12)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (16, N'Cuenca', 8)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (17, N'Girona', 9)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (18, N'Granada', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (19, N'Guadalajara', 8)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (20, N'Gipuzcoa', 16)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (21, N'Huelva', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (22, N'Huesca', 2)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (23, N'Jaén', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (24, N'León', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (25, N'Lleida', 9)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (26, N'La Rioja', 17)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (27, N'Lugo', 12)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (28, N'Madrid', 13)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (29, N'Málaga', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (30, N'Murcia', 14)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (31, N'Navarra', 15)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (32, N'Ourense', 12)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (33, N'Asturias', 3)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (34, N'Palencia', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (35, N'Las Palmas', 5)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (36, N'Pontevedra', 12)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (37, N'Salamanca', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (38, N'Santa Cruz de Tenerife', 5)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (39, N'Cantabria', 6)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (40, N'Segovia', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (41, N'Sevilla', 1)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (42, N'Soria', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (43, N'Tarragona', 9)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (44, N'Teruel', 2)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (45, N'Toledo', 8)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (46, N'València', 10)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (47, N'Valladolid', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (48, N'Bizkaia', 16)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (49, N'Zamora', 7)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (50, N'Zaragoza', 2)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (51, N'Ceuta', 18)
	INSERT [dbo].[provincia] ([idProvincia], [nombre], [idCA]) VALUES (52, N'Melilla', 19)
END


IF ((SELECT COUNT(*) FROM [dbo].[direccion]) =0)
BEGIN
	SET IDENTITY_INSERT [dbo].[direccion] ON 

	INSERT [dbo].[direccion] ([id], [calle], [numero], [poblacion], [idProvincia]) VALUES (1, N'Calle Río Miño', 23, N'Redondela', 36)
	INSERT [dbo].[direccion] ([id], [calle], [numero], [poblacion], [idProvincia]) VALUES (2, N'Avenida de Galicia', 10, N'Vigo', 36)
	INSERT [dbo].[direccion] ([id], [calle], [numero], [poblacion], [idProvincia]) VALUES (3, N'Avenida de Lugo', 10, N'Santiago de Compostela', 15)
	INSERT [dbo].[direccion] ([id], [calle], [numero], [poblacion], [idProvincia]) VALUES (4, N'Avenida de Gran Vía', 10, N'Madrid', 28)
	SET IDENTITY_INSERT [dbo].[direccion] OFF
	
	
END


IF ((SELECT COUNT(*) FROM [dbo].[modulo]) =0)
BEGIN
	SET IDENTITY_INSERT [dbo].[modulo] ON 

	INSERT [dbo].[modulo] ([idModulo], [nombre]) VALUES (1, N'Sistemas Operativos en Red')
	INSERT [dbo].[modulo] ([idModulo], [nombre]) VALUES (2, N'Entornos de desarrollo')
	INSERT [dbo].[modulo] ([idModulo], [nombre]) VALUES (3, N'Sistemas Informáticos')
	INSERT [dbo].[modulo] ([idModulo], [nombre]) VALUES (4, N'Sistemas gestores de bases de datos')
	INSERT [dbo].[modulo] ([idModulo], [nombre]) VALUES (5, N'Programación')
	INSERT [dbo].[modulo] ([idModulo], [nombre]) VALUES (6, N'Lenguaje de marcas')
	SET IDENTITY_INSERT [dbo].[modulo] OFF
END

IF ((SELECT COUNT(*) FROM [dbo].[profesormodulo]) =0)
BEGIN
	INSERT [dbo].[profesormodulo] ([idProfesor], [idModulo]) VALUES (11, 1)
	INSERT [dbo].[profesormodulo] ([idProfesor], [idModulo]) VALUES (11, 2)
	INSERT [dbo].[profesormodulo] ([idProfesor], [idModulo]) VALUES (12, 3)
	INSERT [dbo].[profesormodulo] ([idProfesor], [idModulo]) VALUES (13, 4)
	INSERT [dbo].[profesormodulo] ([idProfesor], [idModulo]) VALUES (13, 5)
	INSERT [dbo].[profesormodulo] ([idProfesor], [idModulo]) VALUES (14, 6)
END




