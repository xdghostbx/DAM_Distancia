
package codigoPlataforma212;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author maria
 */
public class Ejemplos {

    private static final String DIRECTORIO_BASE = Paths.get("C:", "prueba").toString();

    public static void main(String[] args) {

        Path path = Paths.get(DIRECTORIO_BASE, "ejemplo.txt");
        System.out.println("La ruta creada es: " + path.toString());

        crearFichero(path.toString());

        borrarFichero(path.toString());

        Path nuevoDirectorio = Paths.get(DIRECTORIO_BASE, "Nueva carpeta");
        crearDirectorio(nuevoDirectorio.toString());

        Path nuevosDirectorios = Paths.get("carpeta1", "carpeta2", "carpeta3");
        System.out.println("La ruta creada es: " + nuevosDirectorios.toString());
        crearDirectoriosIntermedios(nuevosDirectorios.toString());

    }

    public static void crearFichero(String ruta) {

        try {
            // Creamos el objeto que encapsula el fichero
            File fichero = new File(ruta);
            // A partir del objeto File creamos el fichero físicamente
            if (fichero.createNewFile()) // if comentado
            {
                System.out.println("El fichero " + ruta + " se ha creado correctamente");
            } else {
                System.out.println("No ha podido ser creado el fichero con ruta " + ruta);
            }
        } catch (Exception ioe) {
            ioe.getMessage();
        }

    }

    public static void borrarFichero(String ruta) {
        // Borrar fichero
        boolean borrado = false;
        File fichero = new File(ruta);
        if (fichero.exists()) {
            borrado = fichero.delete();
        }
        if (borrado) {
            System.out.println("El fichero " + ruta + " se ha borrado correctamente.");
        } else {
            System.out.println("El fichero " + ruta + " no se ha borrado correctamente.");
        }

    }

    public static void crearDirectorio(String rutaDir) {
        try {

            boolean exito = (new File(rutaDir)).mkdir();
            if (exito) {
                System.out.println("Directorio: " + rutaDir + " creado");
            } else {
                System.out.println("Directorio: " + rutaDir + " NO ha sido creado");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void crearDirectoriosIntermedios(String rutaDirs) {
        try {

            File file = new File(rutaDirs);

            // Crear varios directorios
            boolean exito = file.mkdirs();
            if (exito) {
                System.out.println("Directorios: " + rutaDirs + " creados");
            } else {
                System.out.println("Directorios: " + rutaDirs + " NO creados");
            }

            System.out.println("La ruta de entrada es: " + file.getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
