
IF NOT EXISTS(SELECT * FROM sys.databases WHERE name = 'instituto')
  BEGIN
    CREATE DATABASE instituto
  END


