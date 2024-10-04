/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ad.cdm.persistencia;

import ad.cdm.model.Persona;
import ad.cdm.model.exceptions.NotFoundPersonaException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mfernandez
 */
public interface IPersistencia {

    void escribirPersonas(ArrayList<Persona> personas, String ruta);

    ArrayList<Persona> leerTodo(String ruta)throws IOException;

    public Persona leerPersona(int posicion, String ruta) throws NotFoundPersonaException;

}
