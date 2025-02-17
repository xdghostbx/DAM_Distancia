/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package bibliotecaVirtual;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Libro libro1 = new Libro("El imperio final","Sanderson", 2010,"Fantasia",true);
    Libro libro2 = new Libro("El archivo de las tormentas","Sanderson", 2010,"Fantasia",true);
    
    CatergoriaLibro fantasia = new CatergoriaLibro ("Fantasia");
    
    fantasia.agregarLibro(libro2);
    fantasia.agregarLibro(libro1);
    
    BibliotecaVirtual biblioteca = new BibliotecaVirtual();
    biblioteca.agregarCategoría(fantasia);
    
    libro1.setDisponible(false );
    
    double disponibles = biblioteca.calcularPorcentaje();
    System.out.println(disponibles);
  }
  
}
