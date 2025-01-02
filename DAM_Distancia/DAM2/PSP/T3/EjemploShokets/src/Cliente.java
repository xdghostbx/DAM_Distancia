import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        int numero = 0;
        Socket socket = new Socket("localhost", 2000); // Conecta con el servidor
        
        // Flujos para la comunicación
        InputStream entrada = socket.getInputStream();
        BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));
        
        OutputStream salida = socket.getOutputStream();
        PrintWriter escritor = new PrintWriter(salida, true);
        while (numero != 1){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce un número");
            int numeroSecreto = scanner.nextInt();
            escritor.println(numeroSecreto);
            // Comunicación
            String mensajeServidor = lector.readLine();

            if (mensajeServidor.equals("Mayor")){
                System.out.println("El número es mayor");
            } else if (mensajeServidor.equals("Menor")){
                System.out.println("El número es menor");
            } else if (mensajeServidor.equals("Correcto")){
                System.out.println("El número es correcto");
                numero = 1;
            }
        }

        // Cerrar conexión
        socket.close();
    }
}
