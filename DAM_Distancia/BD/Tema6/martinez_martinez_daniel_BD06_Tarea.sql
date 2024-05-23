create or replace PROCEDURE CambiarAgentesFamilia(
    id_FamiliaOrigen NUMBER,
    id_FamiliaDestino NUMBER) IS
        NumAgentesCambiados NUMBER; --contador para almacenar el num de agentes cambiados
        NombreFamiliaOrigen familias.nombre%TYPE;
        nombreFamiliaDestino familias.nombre%TYPE;
        
        FUNCTION existe(IdFamilia NUMBER) RETURN BOOLEAN IS --creo una funcion que verifica si existe el numero de familia introducido
            conteo NUMBER;
            
        BEGIN
           conteo := 0;
           SELECT count(*) into conteo
           FROM familias
           WHERE idfamilia = identificador;
           
            IF (conteo = 0) THEN
                RETURN FALSE;
            ELSE
                RETURN TRUE;
            END IF;
        END;    
BEGIN
    --Controlamos la excepcion en caso de familias iguales
    IF (id_FamiliaOrigen = id_FamiliaDestino) THEN
        RAISE_APPLICATION_ERROR(-20001,('Las familias no pueden ser iguales'));
    END IF;    
    
    --Controlamos la excepcion de que la familia ya existe con la funcion "Existe"
    IF NOT existe (id_FamiliaOrigen) THEN
        RAISE_APPLICATION_ERROR(-20002,('La familia '||id_FamiliaOrigen||' no no existe'));
    END IF;    
    IF NOT existe (id_FamiliaDestino) THEN
        RAISE_APPLICATION_ERROR(-20003,('La familia '||id_FamiliaDestino||' no no existe'));
    END IF;
    
    
    SELECT count(*) INTO NumAgentesCambiados
    FROM familias
    WHERE identificador = id_familiaOrigen;
    
    IF (NumAgentesCambiados > 0) THEN
        UPDATE agentes SET familia = id_FamiliaDestino 
        WHERE familia = id_FamiliaOrigen;

        SELECT nombre into NombreFamiliaOrigen
        FROM familias
        WHERE identificador = id_FamiliaOrigen;
        
        SELECT nombre into NombreFamiliaDestino
        FROM familias
        WHERE identificador = id_FamiliaDestino;
        
        DBMS_OUTPUT.PUT_LINE(' Se han trasladado '||NumAgentesCambiados||'  agentes de la familia  '|| NombreFamiliaOrigen || ' a la familia '||  NombreFamiliaDestino);
    ELSE
        DBMS_OUTPUT.PUT_LINE(' La familia  '|| NombreFamiliaOrigen || ' no tiene agentes asociados');    
    END IF;    
END CambiarAgentesFamilia;



-------------------------------------------------------------------------------
--A partir de aqui va el trigger
-------------------------------------------------------------------------------





CREATE OR REPLACE TRIGGER restricciones_agentes
BEFORE insert or update ON AGENTES FOR EACH ROW
BEGIN
        --La longitud de la clave de un agente no puede ser inferior a 6.
    IF LENGTH(:new.clave) < 6 THEN 
        raise_application_error(-20010,'La clave de un agente no puede ser inferior a 6');
    END IF;
        --La habilidad de un agente debe estar comprendida entre 0 y 9 (ambos inclusive).
    IF NOT (:new.habilidad >=0 and :new.habilidad <=9) THEN
        raise_application_error(-20011,'La habilidad de un agente solu puede estar entre 0 y 9 incluidos');
    END IF;    
        --La categoría de un agente sólo puede ser igual a 0, 1 o 2.
    IF :new.categoria NOT IN (1,2,3) THEN
        raise_application_error(-20012,'la categoria solo puede ser 0, 1 o 2');
    END IF;    
        --Si un agente tiene categoría 2 no puede pertenecer a ninguna familia y debe pertenecer a una oficina.  
    IF (:new.categoria = 2) and (:new.familia IS NOT NULL) and (:new.oficina IS NULL) THEN
        raise_application_error(-20013,'UN agente de Cat 2 no puede pertenecer a ninguna familia y debe tener una oficina');
    END IF;    
        --Si un agente tiene categoría 1 no puede pertenecer a ninguna oficina y debe pertenecer  a una familia.  
    IF (:new.categoria = 1) and (:new.oficina IS NOT NULL) and (:new.familia IS NULL) THEN
        raise_application_error(-20014,'UN agente de Cat 1 no puede pertenecer a ninguna oficina y debe tener una familia');
    END IF;     
       -- Todos los agentes deben pertenecer  a una oficina o a una familia pero nunca a ambas a la vez.
    IF ((:new.oficina IS NULL and :new.familia IS NULL) OR (:new.oficina IS NOT NULL and :new.familia IS NOT NULL)) THEN
        raise_application_error(-20015,'Un agente solo puede permanecer a una oficina o a una familia');
    END IF;
END;
