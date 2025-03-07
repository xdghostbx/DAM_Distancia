/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tarea2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class generar_pdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PedidosCliente informe = new PedidosCliente();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un ID de cliente para generar el informe");
        int id_cliente = entrada.nextInt();
        entrada.nextInt();
        informe.ejecutar(id_cliente);
    }
    
}
