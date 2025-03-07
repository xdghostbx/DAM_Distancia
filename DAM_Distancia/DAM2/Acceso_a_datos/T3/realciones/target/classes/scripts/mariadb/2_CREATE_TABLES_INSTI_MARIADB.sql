-- Switch to the 'instituto' database
USE instituto;

-- Create 'profesor' table if it does not exist
CREATE TABLE IF NOT EXISTS profesor (
   Id INT AUTO_INCREMENT NOT NULL,
   nombre VARCHAR(255) NOT NULL,
   ape1 VARCHAR(255) NOT NULL,
   ape2 VARCHAR(255) NOT NULL,
   tipoFuncionario VARCHAR(100) DEFAULT NULL,
   PRIMARY KEY (Id)
);

-- Create 'tiposbasicos' table if it does not exist
CREATE TABLE IF NOT EXISTS tiposbasicos (
   inte INT NOT NULL,
   bigint1 BIGINT DEFAULT NULL,
   smallint1 SMALLINT DEFAULT NULL,
   float1 FLOAT DEFAULT NULL,
   character1 CHAR(1) DEFAULT NULL,
   byte1 TINYINT DEFAULT NULL,
   bit1 BOOLEAN DEFAULT NULL,  -- MariaDB uses BOOLEAN for bit
   stri VARCHAR(255) DEFAULT NULL,
   dateDate DATE DEFAULT NULL,
   timeTime TIME(0) DEFAULT NULL,
   dateTime2 DATETIME(0) DEFAULT NULL,
   texto TEXT,  -- TEXT is used for large text in MariaDB
   binario VARBINARY(255),
   bigDecimal DECIMAL(19,2) DEFAULT NULL,
   PRIMARY KEY (inte)
);

-- Create 'cicloformativo' table if it does not exist
CREATE TABLE IF NOT EXISTS cicloformativo (
   idCiclo INT AUTO_INCREMENT NOT NULL,
   nombreCiclo VARCHAR(100) DEFAULT NULL,
   horas INT DEFAULT NULL,
   PRIMARY KEY (idCiclo)
);
