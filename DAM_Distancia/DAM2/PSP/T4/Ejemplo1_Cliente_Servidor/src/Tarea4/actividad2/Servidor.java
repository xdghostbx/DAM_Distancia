package Tarea4.actividad2;

import java.io.*;
import java.net.*;

public class Servidor extends Thread {
    private Socket skCliente;
    private static final int PUERTO = 1500;
    public Servidor (Socket sCliente){
        skCliente = sCliente;
    }

    public static void main(String[] args) throws IOException {
        try{
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando el puerto " + PUERTO);
            while (true) {
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado");
                new Servidor(skCliente).start();
            }
        }
        catch (IOException e){
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader (skCliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(skCliente.getOutputStream(), true);

            String nombreCliente = lector.readLine();
            System.out.println("Cliente: " + nombreCliente);
            escritor.println("Bienvenido " + nombreCliente);
            int numero = 0;
            while (numero != 1) {
                
                String rutaArchivo = lector.readLine();
                try {
                    FileReader archivo = new FileReader(rutaArchivo);
                    BufferedReader lectorArchivo = new BufferedReader(archivo);
                    String linea = lectorArchivo.readLine();
                    while (linea != null){
                        escritor.println(linea);
                        linea = lectorArchivo.readLine();
                    }
                    escritor.println("___________________");
                    escritor.println("Fin del archivo");
                    numero = 1;
                    lectorArchivo.close();
                    archivo.close();
                } catch (FileNotFoundException e){
                    escritor.println("No se encontro el archivo");
                }
            }

        } catch (IOException e){
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        } finally {
            try {
                skCliente.close();
            } catch (IOException e){
                System.out.println("Error al cerrar el servidor: " + e.getMessage());
            }
        }
    }
}
