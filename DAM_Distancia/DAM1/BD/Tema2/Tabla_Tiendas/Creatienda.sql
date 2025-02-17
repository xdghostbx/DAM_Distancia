--Ejercicio 1:
--Crear tabla familia
CREATE TABLE FAMILIA (
    Codfamilia  NUMBER (3) PRIMARY KEY,
    Denofamilia VARCHAR2 (50) UNIQUE NOT NULL
);

--Crear tabla producto
CREATE TABLE PRODUCTO (
    Codproducto NUMBER(5) PRIMARY KEY,
    Denoproducto VARCHAR2(20) NOT NULL,
    Descripcion VARCHAR2(100),
    PrecioBase NUMBER(8, 2) CHECK (PrecioBase > 0) NOT NULL,
    PorcReposicion NUMBER(3) CHECK (PorcReposicion > 0),
    UnidadesMinimas NUMBER(4) CHECK (UnidadesMinimas > 0) NOT NULL,
    Codfamilia NUMBER(3) REFERENCES FAMILIA (Codfamilia) NOT NULL
);

--Crear tabla tienda
CREATE TABLE TIENDA (
    Codtienda NUMBER(3) PRIMARY KEY,
    Denotienda VARCHAR2(20) NOT NULL,
    Telefono VARCHAR2(11),
    CodigoPostal VARCHAR2(5) NOT NULL,
    Provincia VARCHAR2 (5) NOT NULL
);

--Crear tabla stock
CREATE TABLE STOCK(
    Codtienda NUMBER(3) NOT NULL,
    Codproducto NUMBER(5) NOT NULL,
    Unidades NUMBER(6) CHECK (Unidades >= 0),
    PRIMARY KEY (Codtienda, Codproducto),
    FOREIGN KEY (Codtienda) REFERENCES TIENDA (Codtienda),
    FOREIGN KEY (Codproducto) REFERENCES PRODUCTO (Codproducto)
);

--Comentarios para las columnas de la tabla familia
COMMENT ON COLUMN FAMILIA.Codfamilia IS 'Codigo que distingue una familia de otra';
COMMENT ON COLUMN FAMILIA.Denofamilia IS 'Denominacion de la familia';

--Comentarios para las columnas de la tabla producto
COMMENT ON COLUMN PRODUCTO.Codproducto IS 'Codigo que distingue un producto de otro';
COMMENT ON COLUMN PRODUCTO.Denoproducto IS 'Denominacion del producto';
COMMENT ON COLUMN PRODUCTO.Descripcion IS 'Descripcion del producto';
COMMENT ON COLUMN PRODUCTO.PrecioBase IS 'Precio base del producto';
COMMENT ON COLUMN PRODUCTO.Porcreposicion IS 'Porcentaje de reposicion aplicado a ese producto. Se utilizara para aplicar a las unidades minimas y obtener el numero total de unidades a reponer cuando el stock este bajo minimo';
COMMENT ON COLUMN PRODUCTO.UnidadesMinimas IS 'Unidades minimas recomendables en almacen';
COMMENT ON COLUMN PRODUCTO.Codfamilia IS 'Codigo de la familia a la que pertenece el producto';

--Comentarios para las columnas de la tabla Tienda
COMMENT ON COLUMN TIENDA.Codtienda IS 'Codigo que distingue una tienda de otra';
COMMENT ON COLUMN TIENDA.Denotienda IS 'Denominacion o nombre de la tienda';
COMMENT ON COLUMN TIENDA.Telefono IS 'Telefono de la tienda';
COMMENT ON COLUMN TIENDA.CodigoPostal IS 'Codigo postal donde se ubica la tienda';
COMMENT ON COLUMN TIENDA.Provincia IS 'Provincia donde se ubica la tienda';


--Comentarios para las columnas de la tabla Stock
COMMENT ON COLUMN STOCK.Codtienda IS 'Codigo de la tienda';
COMMENT ON COLUMN STOCK.Codproducto IS 'Codigo del producto';
COMMENT ON COLUMN STOCK.Unidades IS 'Unidades de ese producto en tienda';


