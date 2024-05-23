/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_ejercicio1;

/**
 *
 * @author conde
 */
public class Ejemplo_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //Creo el almacen
        Almacen a = new Almacen();
         
   
        
        a.agregarBebida(new AguaMineral("AquaViva", 1.5, 1, "bezoya"));
        a.agregarBebida(new AguaMineral("PureLife", 3, 2.3, "Liviana"));
        a.agregarBebida(new AguaMineral("Fontoira", 2, 0.75, "bezoya"));
        a.agregarBebida(new AguaMineral("Aquadomus", 4, 1.25, "Solan de cabras"));
        a.agregarBebida(new AguaMineral("Cabreiroá", 2.5, 2.1, "Cabreiroá"));
         
        a.agregarBebida(new BebidaAzucarada(0.2, true, 1.5, 1.5, "Coca Cola"));
        a.agregarBebida(new BebidaAzucarada(0.15, false, 1.5, 2, "Fanta"));
        a.agregarBebida(new BebidaAzucarada(0.25, false, 0.75, 6, "Aquarius"));
        a.agregarBebida(new BebidaAzucarada(0.18, false, 0.5, 1.2, "Pepsi"));
        a.agregarBebida(new BebidaAzucarada(0.24, true, 2, 3.85, "Redbull"));
        //Añado bebidas (un poco de todo)
         
        //Muestro las bebidas
        a.mostrarBebidas();
         
        //Calculo el precio de todas las bebidas
        System.out.println("Precio de todas las bebidas "+a.calcularPrecioBebidas());
         
        //Elimino una bebida en concreto
        a.eliminarBebida(4);
         
        //Muestro las bebidas
        a.mostrarBebidas();
         
        //
        System.out.println("Precio de todas las bebidas: "+a.calcularPrecioBebidas());
         
        System.out.println("Precio de todas las bebidas de la marca bezoya: " +a.calcularPrecioBebidas("bezoya"));
         
        System.out.println("Calcular el precio de la columna 0: "+a.calcularPrecioBebidas(0));
    }
    
}
