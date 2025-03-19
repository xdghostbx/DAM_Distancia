package PaquetePrincipal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HandlerHilos implements Runnable {
    private Socket socketCliente;
    //Capturamos el tiempo inicial de la peticion
    DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", java.util.Locale.ENGLISH); 

    public HandlerHilos(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    @Override
    public void run () {
        try {
            //se captura fecha de entrada
            Date fechaInicio = new Date();
            //procesamos la peticion del cliente
            procesaPeticion(socketCliente);
            //se simula un tiempo de respuesta para que no sea instantaneo
            Thread.sleep(100);
            //se captura la fecha de salida
            Date fechaFin = new Date();
            //se imprime el tiempo de respuesta
            System.out.println("Tiempo de respuesta: " + (fechaFin.getTime() - fechaInicio.getTime()) + " ms");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
   *****************************************************************************
   * procesa la petición recibida
   *
   * @throws IOException
   */
  private static void procesaPeticion(Socket socketCliente) throws IOException {
    //variables locales
    String peticion;
    String html;

    //coloco un try with resourcers para cerrar automaticamente las conexiones al terminar
    try (
        InputStream entrada = socketCliente.getInputStream();
        OutputStream salida = socketCliente.getOutputStream();
        BufferedReader lector = new BufferedReader(new InputStreamReader(entrada));
        PrintWriter escritor = new PrintWriter(salida, true);
    ) {
        peticion = lector.readLine();
        //para compactar la petición y facilitar así su análisis, suprimimos todos 
        //los espacios en blanco que contenga
        peticion = peticion.replaceAll(" ", "");

        //si realmente se trata de una petición 'GET' (que es la única que vamos a
        //implementar en nuestro Servidor)
        if (peticion.startsWith("GET")) {
            //extrae la subcadena entre 'GET' y 'HTTP/1.1'
            peticion = peticion.substring(3, peticion.lastIndexOf("HTTP"));

            //si corresponde a la página de inicio
            if (peticion.length() == 0 || peticion.equals("/")) {
                //sirve la página
                html = Paginas.html_index;
                escritor.println(Mensajes.lineaInicial_OK);
                escritor.println(Paginas.primeraCabecera);
                escritor.println("Content-Length: " + html.length() + 1);
                escritor.println("\n");
                escritor.println(html);
            } //si corresponde a la página del Quijote
            else if (peticion.equals("/quijote")) {
                //sirve la página
                html = Paginas.html_quijote;
                escritor.println(Mensajes.lineaInicial_OK);
                escritor.println(Paginas.primeraCabecera);
                escritor.println("Content-Length: " + html.length() + 1);
                escritor.println("\n");
                escritor.println(html);
            } //en cualquier otro caso
            else {
                //sirve la página
                html = Paginas.html_noEncontrado;
                escritor.println(Mensajes.lineaInicial_NotFound);
                escritor.println(Paginas.primeraCabecera);
                escritor.println("Content-Length: " + html.length() + 1);
                escritor.println("\n");
                escritor.println(html);
            }
        }
    } catch (Exception e) {
        System.err.println(e.getMessage());
    } finally {
        //cierra la conexión con el cliente
        socketCliente.close();
    }
    
  }
}
