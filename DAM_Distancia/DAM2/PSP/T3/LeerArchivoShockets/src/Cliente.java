import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        int numero = 0; // Variable para controlar el bucle
        Socket socket = new Socket("localhost", 1500); // Conecta con el servidor
        
        // Flujos para la comunicación
        InputStream entrada = socket.getInputStream();
        BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));
        
        OutputStream salida = socket.getOutputStream();
        PrintWriter escritor = new PrintWriter(salida, true);

        /**
         * Comunicación
         * 1. El servidor pide la ruta del archivo
         * 2. El cliente envia la ruta del archivo mediante un Scanner
         * 3. El servidor lee el archivo y, si existe, lo envia al cliente
         * 4. Se repite hasta que el cliente envie una ruta valida
         * 5. Se cierran las conexiones
         */
        System.out.println("Introduce la ruta del archivo");
        while (numero != 1){
            Scanner scanner = new Scanner(System.in);
            lector.readLine();
            String ruta = scanner.nextLine();
            escritor.println(ruta);
            String linea = lector.readLine();
            if (linea.equals("No se encontro el archivo")){
                System.out.println(linea);
                continue;
            }else if (linea.equals("Introduce la ruta del archivo")){
                System.out.println(linea);
                continue;
            } else {
                while (!linea.equals("Fin del archivo")){
                    System.out.println(linea);
                    linea = lector.readLine();
                }
                System.out.println("Fin del archivo");
                numero = 1;
            }
            
        }

        // Cerrar conexión
        socket.close();
    }
}
