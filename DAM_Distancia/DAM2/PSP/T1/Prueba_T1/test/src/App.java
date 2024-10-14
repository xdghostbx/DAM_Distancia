

/**
 * Importa la clase Process de java.lang, que proporciona un entorno para la ejecución de procesos.
 */
import java.lang.Process;

/**
 * Importa la clase Runtime de java.lang, que permite interactuar con el entorno de ejecución de la aplicación.
 */
import java.lang.Runtime;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        crearNuevoEditor();

        Process a;
        a = new ProcessBuilder("cmd.exe").start();
    }

    public static void crearNuevoEditor(){
        Process nuevoProceso; //se define una variable de tipo Process
        try{
            //Obtener el nombre del sistema operativo
            String sistemaOperativo = System.getProperty("os.name");
            //Si el sistema operativo es Windows
            if(sistemaOperativo.toUpperCase().contains("WIN")){
                nuevoProceso = Runtime.getRuntime().exec("notepad.exe");
                nuevoProceso = new ProcessBuilder("notepad.exe").start();
            }else{
                //Si el sistema operativo es Linux
                nuevoProceso = Runtime.getRuntime().exec("gedit");
            }
        } catch (SecurityException ex){
            System.out.println("Error de seguridad al ejecutar el comando");
        } catch (Exception ex){
            System.out.println("Error al ejecutar el comando: "+ex.toString());
        }
    }
}


