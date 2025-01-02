import java.io.*;
import java.net.*;
import java.util.Random;


public class Servidor {
    public static void main(String[] args) throws IOException {

        //Se crea el servidor
        ServerSocket servidor = new ServerSocket(2000);
        System.out.println("Servidor iniciado, esperando conexiones...");

        //Esperar a que un cliente se conecte
        Socket socket = servidor.accept();
        System.out.println("Cliente conectado");

        //Flujos para la comunicacion

        //Flujo de entrada
        InputStream entrada = socket.getInputStream();
        BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));

        //Flujo de salida
        OutputStream salida = socket.getOutputStream();
        PrintWriter escritor = new PrintWriter(salida, true);

        /**
         * Comunicacion
         * 1. El servidor genera un numero aleatorio
         * 2. El cliente envia un numero
         * 3. El servidor responde si el numero es mayor, menor o correcto
         * 4. Se repite hasta que el cliente adivine el numero
         * 5. Se cierran las conexiones
         */
        
        Random random = new Random();
        int numeroSecreto = random.nextInt(100);
        System.out.println("Numero secreto: " + numeroSecreto);
        int numero = 0;
        while (numero != 1){
            int numeroCliente = Integer.parseInt(lector.readLine());
            if (numeroCliente > numeroSecreto){
                escritor.println("Menor");
            } else if (numeroCliente < numeroSecreto){
                escritor.println("Mayor");
            } else {
                escritor.println("Correcto");
                numero = 1;
            }
        }
        
        //Cerrar conexiones
        socket.close();
        servidor.close();
    }
}
