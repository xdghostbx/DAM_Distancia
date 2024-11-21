USE empresa;
GO
--insertamos para cada empleado que no tenga ya una cuenta, 1000 + lo que tenga de comisión
  INSERT INTO ACCOUNT(EMPNO, AMOUNT)
  SELECT DISTINCT EMPNO, 1000+ ISNULL(COMM, 0)
  FROM EMP
  WHERE EMPNO NOT IN (SELECT DISTINCT EMPNO FROM ACCOUNT)