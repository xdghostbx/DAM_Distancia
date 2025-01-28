package Tarea4.actividad1;

import java.io.*;
import java.net.*;
import java.util.Random;


public class Servidor extends Thread {
    private Socket skCliente;
    private static final int PUERTO = 2000;
    public Servidor (Socket sCliente){
        skCliente = sCliente;
    }


    public static void main(String[] args) throws IOException {
        try {
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando el puerto " + PUERTO);
            while (true){
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado");
                new Servidor(skCliente).start();
            }
        } catch (IOException e){
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try{
            //flujos de comunicacion
            BufferedReader lector = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(skCliente.getOutputStream(), true);

            String nombreCliente = lector.readLine();
            System.out.println("Cliente: " + nombreCliente);
            escritor.println("Bienvenido " + nombreCliente);
            escritor.println("Introduce un número del 0 al 100, a ver si aciertas!");
            Random random = new Random();
            int numeroSecreto = random.nextInt(100);
            System.out.println("Numero secreto de "+nombreCliente +" es: "+ numeroSecreto);
            int numero = 0;
            while (numero != 1){
                try{
                    int numeroCliente = Integer.parseInt(lector.readLine());
                    if (numeroCliente > numeroSecreto){
                        escritor.println("Menor");
                    } else if (numeroCliente < numeroSecreto){
                        escritor.println("Mayor");
                    } else {
                        escritor.println("Correcto");
                        numero = 1;
                    }
                } catch (NumberFormatException e){
                    escritor.println("Introduce un número válido");
                }
                  
 
            } 
            System.out.println(nombreCliente+" ha acertado, cerrando conexión");
        } catch (IOException e){
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        } finally {
            try {
                skCliente.close();
            } catch (IOException e){
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

