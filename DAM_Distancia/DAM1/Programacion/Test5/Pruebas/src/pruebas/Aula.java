/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package pruebas;

/**
 *
 * @author xdGHOSTbx
 */
public class Aula {
  private Alumno[] nuevoAlumno;
  private int indice;

  public Aula() {
    this.nuevoAlumno = new Alumno[50];
    this.indice = 0;
  }
  
  public int alumnoNuevo(Alumno nuevo){
    if (indice >= 50){
      return -1; //aula llena
    }
    for (int i=0;i< indice;i++){
      if(nuevoAlumno[i].getDNI().equals(nuevo.getDNI())){
        return -2;
      }
    }
    nuevoAlumno[indice] = nuevo;
    indice ++;
    return 0;
  }
}
