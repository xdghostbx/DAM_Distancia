package Tarea4.actividad3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    /**
     * Método principal que establece una conexión con un servidor en localhost en el puerto 1500.
     * Solicita al usuario un nombre de usuario y una contraseña, y luego permite al usuario interactuar
     * con el servidor a través de un menú de opciones.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     * @throws UnknownHostException Si no se puede determinar la dirección del host.
     * @throws IOException Si ocurre un error de E/S al crear el socket o al leer/escribir datos.
     */
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

        /*
         * Si el mensaje recibido del servidor es:
         *  -"Introduce tu contraseña"
         *      El usuario es correcto, entonces se solicita la contraseña
         *  -"Usuario no registrado"
         *      El usuario no es correcto, se muestra el mensaje y se cierra la conexión
         * -"Bienvenido"
         *    El usuario y contraseña son correctos, se muestra el menú de opciones
         * -"Contraseña incorrecta"
         *      La contraseña no es correcta, se muestra el mensaje y se cierra la conexión
         */
        if (respuesta.equals("Introduce tu contraseña:")) {
            String contrasena = scanner.nextLine();
            escritor.println(contrasena);

            respuesta = lector.readLine();
            System.out.println(respuesta);
            
            //Si el servidor acepta el usuario y contraseña, se muestra el menú de opciones
            if (respuesta.startsWith("Bienvenido")) {
                int opcion = 0;

                while (opcion != 3) {
                    /*
                     * Recibir y mostrar el menú de opciones, como lo envia el servidor
                     * leo los mensajes con un bucle en vez de hacerlo uno por uno
                     */
                    
                    for (int i = 0; i < 4; i++) {
                        System.out.println(lector.readLine());
                    }

                    try {
                        opcion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        escritor.println(opcion);
                        String mensajeServidor;
                        switch (opcion) {
                            /*
                             * 1. Ver el contenido del directorio actual
                             * 2. Mostrar el contenido de un archivo
                             * 3. Salir
                             */
                            case 1:
                                System.out.println("Contenido del directorio:");
                                mensajeServidor = lector.readLine();
                                while (!mensajeServidor.equals("Fin del directorio")) {
                                    mensajeServidor = lector.readLine();
                                    System.out.println(mensajeServidor);
                                }
                                break;

                            case 2:
                                // Solicitud de archivo
                                System.out.println(lector.readLine()); 
                                String nombreArchivo = scanner.nextLine();
                                escritor.println(nombreArchivo);
                                mensajeServidor = lector.readLine();
                                while (!mensajeServidor.equals("Fin del archivo")) {
                                    mensajeServidor = lector.readLine();
                                    System.out.println(mensajeServidor);
                                }
                                break;

                            case 3:
                                // Mensaje de salida
                                System.out.println(lector.readLine()); 
                                break;

                            default:
                                // Mensaje de opción no válida
                                System.out.println(lector.readLine()); 
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida.");
                        scanner.nextLine(); // Limpiar buffer
                    }
                }
            } else {
                // Mensaje de contraseña incorrecta
                System.out.println(respuesta);
            }
        } else {
            // Mensaje de usuario no registrado
            System.out.println(respuesta);
        }
        socket.close();
        scanner.close();
    }
}
