package Tarea4.actividad1;

import java.io.*;
import java.net.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        int numero = 0; // Variable para controlar el bucle
        Socket socket = new Socket("localhost", 2000); // Conecta con el servidor
        
        // Flujos para la comunicacion
        InputStream entrada = socket.getInputStream();
        BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));
        
        OutputStream salida = socket.getOutputStream();
        PrintWriter escritor = new PrintWriter(salida, true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre:");
        String nombre = scanner.nextLine();
        escritor.println(nombre);
        String mensajeServidor = lector.readLine();
        System.out.println(mensajeServidor);
        mensajeServidor = lector.readLine();
        System.out.println(mensajeServidor);

        /**
         * Comunicacion
         * 1. El servidor genera un numero aleatorio
         * 2. El cliente envia un numero mediante un scanner
         * 3. El servidor responde si el numero es mayor, menor o correcto
         * 4. Se repite hasta que el cliente adivine el numero
         * 5. Se cierran las conexiones
         */

        while (numero != 1){
            try{
                System.out.println("Introduce un número");
                int numeroSecreto = scanner.nextInt();
                escritor.println(numeroSecreto);
                // Comunicación
                mensajeServidor = lector.readLine();

                if (mensajeServidor.equals("Mayor")){
                    System.out.println("El número es mayor");
                } else if (mensajeServidor.equals("Menor")){
                    System.out.println("El número es menor");
                } else if (mensajeServidor.equals("Correcto")){
                    System.out.println("El número es correcto");
                    numero = 1;
                }
            } catch (InputMismatchException e){
                System.out.println("Introduce un número válido");
                scanner.next();
            }

            
        }

        // Cerrar conexión
        socket.close();
    }
}
