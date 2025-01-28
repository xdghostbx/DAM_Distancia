package Tarea4.actividad2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        int numero = 0;
        Socket socket = new Socket ("Localhost", 1500);
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
        

        while (numero != 1) {
            System.out.println("Introduce la ruta del archivo:");
            String ruta = scanner.nextLine();
            escritor.println(ruta);
            mensajeServidor = lector.readLine();

            if(mensajeServidor.equals("No se encontro el archivo")) {
                System.out.println(mensajeServidor);
            } else if (mensajeServidor.equals("Introduce la ruta del archivo")){
                System.out.println(mensajeServidor);
            } else {
                while (!mensajeServidor.equals("Fin del archivo")) {
                    System.out.println(mensajeServidor);
                    mensajeServidor = lector.readLine();
                }
                System.out.println("Fin del archivo");
                numero = 1;
            }
        }

    }
}
