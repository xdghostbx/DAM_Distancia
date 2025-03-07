USE instituto;

-- Insert into comunidadAutonoma table
INSERT IGNORE INTO comunidadAutonoma (idCA, nombre) VALUES 
(1, 'Andalucía'),
(2, 'Aragón'),
(3, 'Asturias, Principado de'),
(4, 'Illes Balears'),
(5, 'Canarias'),
(6, 'Cantabria'),
(7, 'Castilla y León'),
(8, 'Castilla - La Mancha'),
(9, 'Cataluña'),
(10, 'Comunitat Valenciana'),
(11, 'Extremadura'),
(12, 'Galicia'),
(13, 'Comunidad de Madrid'),
(14, 'Región de Murcia'),
(15, 'Comunidad Foral de Navarra'),
(16, 'País Vasco'),
(17, 'Rioja, La'),
(18, 'Ceuta'),
(19, 'Melilla');

-- Insert into provincia table
INSERT IGNORE INTO provincia (idProvincia, nombre, idCA) VALUES
(1, 'Araba', 16),
(2, 'Albacete', 8),
(3, 'Alacant', 10),
(4, 'Almería', 1),
(5, 'Ávila', 7),
(6, 'Badajoz', 11),
(7, 'Illes Balears', 4),
(8, 'Barcelona', 9),
(9, 'Burgos', 7),
(10, 'Cáceres', 11),
(11, 'Cádiz', 1),
(12, 'Castelló', 10),
(13, 'Ciudad Real', 8),
(14, 'Córdoba', 1),
(15, 'A Coruña', 12),
(16, 'Cuenca', 8),
(17, 'Girona', 9),
(18, 'Granada', 1),
(19, 'Guadalajara', 8),
(20, 'Gipuzcoa', 16),
(21, 'Huelva', 1),
(22, 'Huesca', 2),
(23, 'Jaén', 1),
(24, 'León', 7),
(25, 'Lleida', 9),
(26, 'La Rioja', 17),
(27, 'Lugo', 12),
(28, 'Madrid', 13),
(29, 'Málaga', 1),
(30, 'Murcia', 14),
(31, 'Navarra', 15),
(32, 'Ourense', 12),
(33, 'Asturias', 3),
(34, 'Palencia', 7),
(35, 'Las Palmas', 5),
(36, 'Pontevedra', 12),
(37, 'Salamanca', 7),
(38, 'Santa Cruz de Tenerife', 5),
(39, 'Cantabria', 6),
(40, 'Segovia', 7),
(41, 'Sevilla', 1),
(42, 'Soria', 7),
(43, 'Tarragona', 9),
(44, 'Teruel', 2),
(45, 'Toledo', 8),
(46, 'València', 10),
(47, 'Valladolid', 7),
(48, 'Bizkaia', 16),
(49, 'Zamora', 7),
(50, 'Zaragoza', 2),
(51, 'Ceuta', 18),
(52, 'Melilla', 19);

-- Insert into direccion table
INSERT IGNORE INTO direccion (id, calle, numero, poblacion, idProvincia) VALUES
(1, 'Calle Río Miño', 23, 'Redondela', 36),
(2, 'Avenida de Galicia', 10, 'Vigo', 36),
(3, 'Avenida de Lugo', 10, 'Santiago de Compostela', 15),
(4, 'Avenida de Gran Vía', 10, 'Madrid', 28);

-- Insert into modulo table
INSERT IGNORE INTO modulo (idModulo, nombre) VALUES
(1, 'Sistemas Operativos en Red'),
(2, 'Entornos de desarrollo'),
(3, 'Sistemas Informáticos'),
(4, 'Sistemas gestores de bases de datos'),
(5, 'Programación'),
(6, 'Lenguaje de marcas');

-- Insert into profesormodulo table
INSERT IGNORE INTO profesormodulo (idProfesor, idModulo) VALUES
(11, 1),
(11, 2),
(12, 3),
(13, 4),
(13, 5),
(14, 6);
