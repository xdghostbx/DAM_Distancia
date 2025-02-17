
import java.util.Scanner;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class PruebaVehiculo {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Bicicleta bicicleta1 = new Bicicleta("Juanito");
    Coche coche1 = new Coche ("Ferrari");
    Scanner entrada = new Scanner(System.in);
    int opcion = 0, km = 0;
    while (opcion != 8) {
      System.out.println("\n1. Anda con la bicicleta");
      System.out.println("2. Haz el caballito con la bicicleta");
      System.out.println("3. Anda con el coche");
      System.out.println("4. Quema rueda con el coche");
      System.out.println("5. Ver kilometraje de la bicicleta");
      System.out.println("6. Ver kilometraje del coche");
      System.out.println("7. Ver kilometraje total");
      System.out.println("8. Salir");
      System.out.println("Elige una opción (1-8): ");
      opcion = entrada.nextInt();
      entrada.nextLine();
      
      switch (opcion){
        case 1: 
          System.out.println("Cuanto kilometos recorre?");
          km = entrada.nextInt();
          entrada.nextLine();
          bicicleta1.recorre(km);
          break;
        case 2:
          bicicleta1.hazCaballito();
          break;
        case 3:
          System.out.println("Cuanto kilometos recorre?");
          km = entrada.nextInt();
          entrada.nextLine();
          coche1.recorre(km);
          break;
        case 4:
          coche1.derrapa();
          break;
        case 5:
          System.out.println("La bicicleta lleva "+bicicleta1.getKilometrosRecorridos()+" km");
          break;
        case 6:
          System.out.println("El coche lleva "+coche1.getKilometrosRecorridos()+" km");
          break;
        case 7:
          System.out.println("Los kilometros totales son "+Vehiculo.getKilometrosTotales()+" km");
          break;
        default:
          break;
      }
    }
  }
  
}
