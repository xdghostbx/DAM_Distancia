package Tarea4.actividad3;

import java.io.*;
import java.net.*;

public class Servidor extends Thread {
    private Socket skCliente;
    private static final int PUERTO = 1500;
    private static final String USUARIO = "javier";
    private static final String PSWORD = "secreta";

    // Constructor que recibe el socket del cliente
    public Servidor(Socket skCliente) {
        this.skCliente = skCliente;
    }

    public static void main(String[] args) throws IOException {
        try {
            // Crear un ServerSocket para escuchar en el puerto especificado
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escuchando el puerto " + PUERTO);

            // Bucle infinito para aceptar conexiones de clientes
            while (true) {
                Socket skCliente = skServidor.accept();
                System.out.println("Cliente conectado");
                // Crear un nuevo hilo para manejar la conexión del cliente
                new Servidor(skCliente).start();
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        } 
    }

    @Override
    public void run() {
        try {
            // Crear lectores y escritores para la comunicación con el cliente
            BufferedReader lector = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
            PrintWriter escritor = new PrintWriter(skCliente.getOutputStream(), true);

            // Solicitar nombre de usuario
            escritor.println("Introduce tu nombre de usuario:");
            String nombreCliente = lector.readLine();

            // Verificar nombre de usuario
            if (nombreCliente.equals(USUARIO)) {
                escritor.println("Introduce tu contraseña:");
                String contrasenaCliente = lector.readLine();

                // Verificar contraseña
                if (contrasenaCliente.equals(PSWORD)) {
                    escritor.println("Bienvenido " + nombreCliente);
                    int opcion = 0;

                    // Bucle para manejar el menú de opciones
                    while (opcion != 3) {
                        // Enviar menú al cliente
                        escritor.println("1. Ver contenido del directorio actual");
                        escritor.println("2. Mostrar contenido de un archivo");
                        escritor.println("3. Salir");
                        escritor.println("Elige una opción:");
                        
                        try {
                            opcion = Integer.parseInt(lector.readLine());

                            switch (opcion) {
                                case 1:
                                    // Mostrar contenido del directorio actual mediante "."
                                    File directorio = new File(".");
                                    File[] archivos = directorio.listFiles();
                                    escritor.println("Contenido del directorio actual:");
                                    for (File archivo : archivos) {
                                        if (archivo.isFile()) {
                                            escritor.println(archivo.getName());
                                        } else {
                                            escritor.println(archivo.getName() + "/");
                                        }
                                    }
                                    escritor.println("Fin del directorio");
                                    break;

                                case 2:
                                    // Mostrar contenido de un archivo
                                    escritor.println("Introduce el nombre del archivo:");
                                    String nombreArchivo = lector.readLine();
                                    File archivo = new File(nombreArchivo);

                                    if (archivo.exists() && archivo.isFile()) {
                                        BufferedReader lectorArchivo = new BufferedReader(new FileReader(archivo));
                                        String linea;
                                        while ((linea = lectorArchivo.readLine()) != null) {
                                            escritor.println(linea);
                                        }
                                        lectorArchivo.close();
                                        escritor.println("Fin del archivo");
                                    } else {
                                        escritor.println("Archivo no encontrado");
                                    }
                                    break;

                                case 3:
                                    // Salir
                                    escritor.println("Cerrando conexión...");
                                    break;

                                default:
                                    escritor.println("Opción no válida");
                                    break;
                            }
                        } catch (NumberFormatException e) {
                            escritor.println("Entrada no válida. Introduce un número.");
                        }
                    }
                } else {
                    escritor.println("Contraseña incorrecta.");
                }
            } else {
                escritor.println("Usuario no registrado.");
            }

        } catch (IOException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        } finally {
            try {
                // Cerrar la conexión con el cliente
                skCliente.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
