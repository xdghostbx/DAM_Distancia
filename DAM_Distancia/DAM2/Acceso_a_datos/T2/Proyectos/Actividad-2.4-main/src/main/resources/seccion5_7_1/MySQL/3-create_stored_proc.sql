use test; 

-- --------------------------------------------------------------------------------
-- Routine DDL
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertaCliente`(IN Cod_Cliente INTEGER, IN Nombre TinyText,IN Telefono TinyText )
BEGIN
INSERT INTO clientes
	VALUES (Cod_Cliente,
		Nombre,
		Telefono);

END