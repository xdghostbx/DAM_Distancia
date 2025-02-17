
import java.util.Scanner;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class PruebaZona {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
   Zona principal = new Zona(1000);
   Zona cV = new Zona (200);
   Zona Vip = new Zona (25);
   int opcion = 0 ,n;
   Scanner entrada = new Scanner(System.in);
   do{
     System.out.println("1- Mostrar entradas libres");
     System.out.println("2- Vender entradas");
     System.out.println("3- Salir");
     opcion = entrada.nextInt();
     entrada.nextLine();
     
     switch (opcion){
       case 1:
         System.out.println("Me quedan");
         System.out.println(principal.getEntradasPorVender()+" en la zona principal");
         System.out.println(cV.getEntradasPorVender()+ " en la zona de compraventa");
         System.out.println(Vip.getEntradasPorVender()+" en la zona VIP");
         break;
       case 2:
         System.out.println("Seleccione la zona");
         System.out.println("1- principal");
         System.out.println("2- compraventa");
         System.out.println("3- Vip");
         int zona = entrada.nextInt();
         entrada.nextLine();
         
         switch (zona){
           case 1:
             System.out.println("Cuantas entradas quieres?");
             n=entrada.nextInt();
             entrada.nextLine();
             principal.vender(n);
             break;
           case 2:
             System.out.println("Cuantas entradas quieres?");
             n=entrada.nextInt();
             entrada.nextLine();
             cV.vender(n);
             break;
           case 3:
             System.out.println("Cuantas entradas quieres?");
             n=entrada.nextInt();
             entrada.nextLine();
             Vip.vender(n);
             break;
         }
         
         break;
       default:
     }
   }while(opcion != 3);
  }
  
}
