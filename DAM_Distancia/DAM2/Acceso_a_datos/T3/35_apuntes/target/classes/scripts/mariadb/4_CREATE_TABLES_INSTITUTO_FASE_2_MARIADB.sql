-- Switch to the 'instituto' database
USE instituto;

-- Create 'comunidadAutonoma' table if it doesn't exist
CREATE TABLE IF NOT EXISTS comunidadAutonoma (
    idCA INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (idCA)
);

-- Create 'provincia' table if it doesn't exist
CREATE TABLE IF NOT EXISTS provincia (
    idProvincia INT NOT NULL,
    nombre VARCHAR(100) DEFAULT NULL,
    idCA INT NOT NULL,
    PRIMARY KEY (idProvincia),
    FOREIGN KEY (idCA) REFERENCES comunidadAutonoma(idCA)
);

-- Create 'direccion' table if it doesn't exist
CREATE TABLE IF NOT EXISTS direccion (
    id INT AUTO_INCREMENT NOT NULL,
    calle VARCHAR(255) DEFAULT NULL,
    numero INT DEFAULT NULL,
    poblacion VARCHAR(255) DEFAULT NULL,
    idProvincia INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idProvincia) REFERENCES provincia(idProvincia)
);

-- Create 'modulo' table if it doesn't exist
CREATE TABLE IF NOT EXISTS modulo (
    idModulo INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY (idModulo)
);

-- Create 'profesormodulo' table if it doesn't exist
CREATE TABLE IF NOT EXISTS profesormodulo (
    idProfesor INT NOT NULL,
    idModulo INT NOT NULL,
    PRIMARY KEY (idModulo, idProfesor),
    FOREIGN KEY (idModulo) REFERENCES modulo(idModulo),
    FOREIGN KEY (idProfesor) REFERENCES profesor(Id)
);
