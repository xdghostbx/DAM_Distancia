

/**
 * Importa la clase Process de java.lang, que proporciona un entorno para la ejecución de procesos.
 */
import java.lang.Process;

/**
 * Importa la clase Runtime de java.lang, que permite interactuar con el entorno de ejecución de la aplicación.
 */
import java.lang.Runtime;

import java.io.IOException;
public class App {
    public static void main(String[] args) throws Exception {
        try{
            ejecutarEditorText();
            ejecutarConsolaComandos();
        }catch(IOException e){
            System.err.println("Error al ejecutar el proceso: ");
            System.err.println(e.getMessage());
        }catch(SecurityException e){
            System.err.println("Error de seguridad al ejecutar el proceso: ");
            System.err.println(e.getMessage());
        }catch(UnsupportedOperationException e){
            System.err.println(e.getMessage());
        }
    }

    public static void ejecutarEditorText() throws IOException{
        //Obtener el nombre del sistema operativo y guardarlo en una variable
        String osName = System.getProperty("os.name").toUpperCase();
        if (osName.contains("WIN")){
            ejecutarProceso("notepad.exe");
        }else if (osName.contains("LINUX")){
            ejecutarProceso("gedit");
        }else{
            throw new UnsupportedOperationException("Sistema operativo no soportado");
        }
    }

    public static void ejecutarConsolaComandos() throws IOException{
        ejecutarProceso("cmd.exe");
    }

    public static void ejecutarProceso(String comando) throws IOException{
        new ProcessBuilder(comando).start();
    }
}



