package Tarea_opcional.tareaOpcional;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 1500);
        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        // Solicitud de usuario
        System.out.println(lector.readLine()); 
        String usuario = scanner.nextLine();
        escritor.println(usuario);

        // Captura de respuesta del servidor
        String respuesta = lector.readLine();
        System.out.println(respuesta); 

        
        if (respuesta.equals("Introduce tu contraseña:")) {
            String contrasena = scanner.nextLine();
            escritor.println(contrasena);

            respuesta = lector.readLine();
            
            //Si el servidor acepta el usuario y contraseña, se muestra el menú de opciones
            if (respuesta.startsWith("Bienvenido")) {
                String opcion = "";

                while (!opcion.equals("fin") && !opcion.equals("shutdown")) {
                    
                    System.out.println(lector.readLine());

                    try {
                        opcion = scanner.nextLine();
                        escritor.println(opcion);
                        String mensajeServidor;

                        // Recibir y mostrar la respuesta del servidor
                        do {
                            mensajeServidor = lector.readLine();
                            System.out.println(mensajeServidor);
                            break;
                        } while (!(mensajeServidor.startsWith("Hasta luego"))&&!(mensajeServidor.startsWith("cerrando el servidor...")));
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                }
            //mensaje de usuario ya conectado
            } else if (respuesta.equals("Usuario ya conectado, desconectando...")) {
                // Mensaje de contraseña incorrecta
                System.out.println("Usuario ya conectado, desconectando...");
            }else if (respuesta.equals("Contraseña incorrecta.")){
                System.out.println("Contraseña incorrecta.");
            }
        } else if (respuesta.equals("Usuario no registrado.")) {
            // Mensaje de usuario no registrado
            System.out.println("Usuario no registrado.");
        }
        socket.close();
        scanner.close();
    }
}
