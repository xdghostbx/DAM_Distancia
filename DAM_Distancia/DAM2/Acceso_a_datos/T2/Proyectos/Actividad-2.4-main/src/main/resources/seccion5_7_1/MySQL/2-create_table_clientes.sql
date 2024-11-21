use test; 
delimiter $$

CREATE TABLE `clientes` (
-- sin (3)
  `Cod_Cliente` int NOT NULL DEFAULT '0',
  `Nombre` tinytext,
  `Telefono` tinytext,
  PRIMARY KEY (`Cod_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$
