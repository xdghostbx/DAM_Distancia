/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package tutoria;

/**
 *
 * @author xdGHOSTbx
 */
public class PROG03_tutoria {

    public static void main(String[] args) {
        Persona Dani = new Persona();
            Dani.setNombre("Dani");
            Dani.setApellidos("Martinez");
            Dani.setEdad(28);
            Dani.setPeso(80);
            Dani.setEstatura(172);
            Dani.setCodigo(3113);
            
        Persona Luis = new Persona();
            Luis.setNombre("Luis");
            Luis.setApellidos("Gonzalez");
            Luis.setEdad(26);
            Luis.setPeso(90);
            Luis.setEstatura(181);
            Luis.setCodigo(4200);
            
        Persona Usuario = new Persona();
        Persona Usuario2 = new Persona();
        Persona Usuario3 = new Persona("Paco", "Perez Perez", 15, 50,169,3113);
        Persona Sandra = new Persona();
            Sandra.setNombre("Sandra");
            Sandra.setApellidos("Veleiro");
            Sandra.setEdad(29);
            Sandra.setPeso(50);
            Sandra.setEstatura(170);
            Sandra.setCodigo(3366);
            
        Dani.imprimirDatos();
        Luis.imprimirDatos();
        Sandra.imprimirDatos();
    }
}
