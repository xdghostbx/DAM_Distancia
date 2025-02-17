import java.io.*;
import java.net.*;
import java.util.Random;


public class Servidor {
    public static void main(String[] args) throws IOException {
        // Se crea el servidor
        ServerSocket servidor = new ServerSocket(1500);
        System.out.println("Servidor iniciado, esperando conexiones...");

        // Esperar a que un cliente se conecte
        Socket socket = servidor.accept();
        System.out.println("Cliente conectado");

        //Flujos para la cominicacion

        //Flujo de entrada
        InputStream entrada = socket.getInputStream();
        BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));


        //Flujo de salida
        OutputStream salida = socket.getOutputStream();
        PrintWriter escritor = new PrintWriter(salida, true);

        //Comunicacion
        /**
         * Comunicacion
         * 1. El servidor pide la ruta del archivo
         * 2. El cliente envia la ruta del archivo
         * 3. El servidor lee el archivo y, si existe, lo envia al cliente
         * 4. Se repite hasta que el cliente envie una ruta valida
         * 5. Se cierran las conexiones
         */
        int numero = 0;
        while (numero != 1){
            escritor.println("Introduce la ruta del archivo");
        
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
        //Cerrar conexiones
        socket.close();
        servidor.close();
    }
}
