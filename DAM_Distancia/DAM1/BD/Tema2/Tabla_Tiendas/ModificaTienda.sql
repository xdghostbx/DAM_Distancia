--Ejercicio 2 partado A

--Añadir a la tabla Stock
ALTER TABLE STOCK
ADD (
    FechaUltimaEntrada DATE DEFAULT SYSDATE,
    Beneficio NUMBER (1,0) CHECK (Beneficio IN (1,2,3,4,5))
);

--Modificar tabla producto
ALTER TABLE PRODUCTO
MODIFY(
    Denoproducto VARCHAR2(50),
    perecedero CHAR(1) CHECK (perecedero IN ('S', 'N'))
);
Alter table PRODUCTO
DROP ( 
    COLUMN Descripcion
);

--Modificar tabla familia
ALTER TABLE FAMILIA
ADD(
    IVA NUMBER (2,0) CHECK IVA IN (21, 10, 4)
);

--Modificar tabla tienda
 