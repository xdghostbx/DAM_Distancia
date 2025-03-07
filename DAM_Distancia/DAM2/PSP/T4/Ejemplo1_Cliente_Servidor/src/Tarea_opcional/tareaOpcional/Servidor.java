package Tarea_opcional.tareaOpcional;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import Tarea_opcional.tareaOpcional.Persona;

public class Servidor extends Thread {
    private Socket skCliente;
    private static final int PUERTO = 1500;
    private static Map<String, Persona> usuarios = new HashMap<>();
    private static volatile Boolean cierre = false;
    private static ServerSocket skServidor;
    

    // Constructor que recibe el socket del cliente
    public Servidor(Socket skCliente) {
        this.skCliente = skCliente;
    }

    public static void main(String[] args) throws IOException {
        //agregamos usuarios y contraseñas al map
        usuarios.put("javier",new Persona("javier","1234"));
        usuarios.put("david",new Persona("david","1234"));
        usuarios.put("luis",new Persona("luis","1234"));
        usuarios.put("maria",new Persona("maria","1234"));
        usuarios.put("pedro",new Persona("pedro","1234"));
        usuarios.put("juan",new Persona("juan","1234"));
        usuarios.put("ana",new Persona("ana","1234"));
        usuarios.put("laura",new Persona("laura","1234"));
        usuarios.put("carlos",new Persona("carlos","1234"));


        try {
            // Crear un ServerSocket para escuchar en el puerto especificado
            skServidor = new ServerSocket(PUERTO);
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
        } finally {
            System.out.println("Cerrando el servidor...");
            skServidor.close();
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
            if (usuarios.containsKey(nombreCliente)) {
                escritor.println("Introduce tu contraseña:");
                String contrasenaCliente = lector.readLine();

                // Verificar contraseña
                if (usuarios.get(nombreCliente).getContraseña().equals(contrasenaCliente)
                        && !usuarios.get(nombreCliente).isConectado()) {
                    // Incrementar el número de conexiones del usuario
                    usuarios.get(nombreCliente).incrementarConexiones();
                    usuarios.get(nombreCliente).setConectado(true);

                    escritor.println("Bienvenido " + nombreCliente);
                    String opcion = "";

                    // Bucle para manejar el menú de opciones
                    while (!opcion.equals("fin")) {
                        escritor.println("Introduce un nombre de usuario o 'fin' para salir:");
                        
                        try {
                            opcion = lector.readLine();
                            if (usuarios.containsKey(opcion)) {
                                escritor.println(usuarios.get(opcion).toString());
                            } else if (opcion.equals("fin")) {
                                escritor.println("Hasta luego " + nombreCliente);
                                usuarios.get(nombreCliente).setConectado(false);
                            } else if (opcion.equals("shutdown")){
                                escritor.println("cerrando el servidor...");
                                usuarios.get(nombreCliente).setConectado(false);
                                skCliente.close();
                                skServidor.close();
                            } else {
                                escritor.println("Usuario no encontrado.");
                            }
                            
                            
                        } catch (NumberFormatException e) {
                            escritor.println("Entrada no válida. Introduce un número.");
                        }
                    }
                } else if (usuarios.get(nombreCliente).isConectado()) {
                    escritor.println("Usuario ya conectado, desconectando...");
                    skCliente.close();
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
