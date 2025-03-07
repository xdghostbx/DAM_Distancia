use instituto;
Go

  IF OBJECT_ID(N'dbo.profesor', N'U') IS  NULL
BEGIN
CREATE TABLE profesor (
   Id  int IDENTITY(1,1) NOT NULL,
   nombre  varchar(255) NOT NULL,
   ape1  varchar(255) NOT NULL,
   ape2  varchar(255) NOT NULL,
   tipoFuncionario  varchar(100) DEFAULT NULL,
  PRIMARY KEY ( Id )
) ;
END

IF OBJECT_ID(N'dbo.tiposbasicos', N'U') IS  NULL
BEGIN

CREATE TABLE tiposbasicos (
   inte  int NOT NULL,
  bigint1  bigint DEFAULT NULL,
   smallint1  smallint DEFAULT NULL,
   float1  float DEFAULT NULL, 
   character1  char(1) DEFAULT NULL,
  byte1  tinyint DEFAULT NULL,
  bit1  bit DEFAULT NULL,
   stri  varchar(255) DEFAULT NULL,
   dateDate  date DEFAULT NULL,
   timeTime  time(0) DEFAULT NULL,
   dateTime2  datetime2(0) DEFAULT NULL,
   texto  varchar(max),
   binario  varbinary(255),
   bigDecimal  decimal(19,2) DEFAULT NULL,
  
  PRIMARY KEY ( inte )
) ;

END

IF OBJECT_ID(N'dbo.cicloformativo', N'U') IS  NULL
BEGIN
CREATE TABLE cicloformativo (
   idCiclo  int  IDENTITY(1,1) NOT NULL,
   nombreCiclo  varchar(100) DEFAULT NULL,
   horas  int DEFAULT NULL,
  PRIMARY KEY ( idCiclo )
) ;


END