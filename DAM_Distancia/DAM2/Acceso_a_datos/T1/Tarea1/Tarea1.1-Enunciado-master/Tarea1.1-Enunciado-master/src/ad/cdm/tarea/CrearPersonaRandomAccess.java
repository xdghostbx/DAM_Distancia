/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.cdm.tarea;

import ad.cdm.model.Persona;
import ad.cdm.persistencia.IPersistencia;
import ad.cdm.persistencia.RandomAccessPersistencia;
import ad.cdm.util.LogUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class CrearPersonaRandomAccess {

    static final Logger logger = Logger.getLogger(CrearPersonaRandomAccess.class.getName());

    private static ArrayList<Persona> crearPersonas() {

        ArrayList<Persona> personas = new ArrayList<>();

        Persona personaA = new Persona(1, "12345678A", 20, 20000.65f, "Ana");
        Persona personaB = new Persona(2, "12345678B", 30, 30000.65f, "Bea");
        Persona personaC = new Persona(3, "12345678C", 40, 40000.65f, "Casilda");
        Persona personaD = new Persona(4, "12345678D", 50, 20000.65f, "Dionisio");
        Persona personaE = new Persona(5, "12345678E", 60, 30000.65f, "Eva");
        Persona personaF = new Persona(6, "12345678F", 70, 40000.65f, "Flor");

        personaB.setBorrado(true);

        personaC.setBorrado(true);
        personaD.setBorrado(true);

        personas.add(personaA);
        personas.add(personaB);
        personas.add(personaC);
        personas.add(personaD);
        personas.add(personaE);
        personas.add(personaF);

        return personas;

    }

    public static void main(String[] args) {
        LogUtil.setLogger();

        ArrayList<Persona> personas = crearPersonas();
        ArrayList<Persona> personasRecuperadas = new ArrayList<>();
        
        //Borrar el fichero de PERSONAS_ORIGEN_PATH_RAN si existe
        Path ruta = Tarea11Sol.PERSONAS_ORIGEN_PATH_RAN;
        if (Files.exists(ruta)){
            try{
                Files.delete(ruta);
            } catch (IOException ex){
                logger.log(Level.SEVERE, "Error", ex);
            }
        }
        IPersistencia dao = new RandomAccessPersistencia();
        dao.escribirPersonas(personas, Tarea11Sol.PERSONAS_ORIGEN_PATH_RAN.toString());

        try {
            personasRecuperadas = dao.leerTodo(Tarea11Sol.PERSONAS_ORIGEN_PATH_RAN.toString());
            int contador = 1;
            for (Persona p : personasRecuperadas) {
                System.out.println("Persona recuperada " + contador + ": " + p);
                contador++;
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Ocorreu unha excepción", ex);
        }

    }

}
