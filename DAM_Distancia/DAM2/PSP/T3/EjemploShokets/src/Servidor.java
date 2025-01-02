import java.io.*;
import java.net.*;
import java.util.Random;


public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(2000);
        System.out.println("Servidor iniciado, esperando conexiones...");

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
        /*escritor.println("Hola cliente");
        String mensaje = lector.readLine();
        System.out.println("Mensaje del cliente: " + mensaje);*/
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
