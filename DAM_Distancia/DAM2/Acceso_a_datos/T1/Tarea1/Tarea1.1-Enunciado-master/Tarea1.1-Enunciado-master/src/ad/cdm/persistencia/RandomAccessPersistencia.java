/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.cdm.persistencia;

import ad.cdm.model.Persona;
import ad.cdm.model.exceptions.NotFoundPersonaException;
import ad.cdm.util.LogUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfernandez
 */
public class RandomAccessPersistencia implements IPersistencia {

   

    static final Logger logger = Logger.getLogger(RandomAccessPersistencia.class.getName());

    public RandomAccessPersistencia() {
        LogUtil.setLogger();
    }

    @Override
    public void escribirPersonas(ArrayList<Persona> personas, String ruta) {
        long longitudBytes = 0;
        //en este metodo tuve que cambiar las cosas de orden al correcto de como están en persona
        //si no a la hora de imprimir los datos no se imprimen correctamente
        if (personas != null) {
            try (
                    RandomAccessFile raf = new RandomAccessFile(ruta, "rw");) {

                longitudBytes = raf.length();
                raf.seek(longitudBytes);
                for (Persona persona : personas) {

                    raf.writeLong(persona.getId());

                    StringBuilder sb = new StringBuilder(persona.getDni());
                    sb.setLength(Persona.MAX_LENGTH_DNI);

                    raf.writeChars(sb.toString());
                    raf.writeInt(persona.getEdad());
                    raf.writeFloat(persona.getSalario());
                    raf.writeBoolean(persona.isBorrado());

                    sb = new StringBuilder(persona.getNombre());
                    sb.setLength(Persona.MAX_LENGTH_NOMBRE);
                    raf.writeChars(sb.toString());

                }

            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Se ha producido una excepción: ", ex);
            }
        }

    }
    /**
     * Lee todo el contenido del archivo y lo devuelve en un ArrayList
     * 
     * @param ruta
     * @return
     * @throws IOException
     * 
     *  Calculo cuanto ocupa cada registro en bytes
     *   long 8 bytes (id)
     *   char 2 bytes * 9 (dni)
     *   int 4 bytes (edad)
     *   float 4 bytes (salario)
     *   boolean 1 byte (borrado)
     *   char 2 bytes * 100 (nombre)
     * Total: 8 + 18 + 4 + 4 + 1 + 200 = 235 bytes por registro
     */

    public static final int tamano_registro = 235;

    @Override
    public ArrayList<Persona> leerTodo(String ruta) throws IOException {
       
        ArrayList<Persona> personas = new ArrayList<>();
        try(RandomAccessFile raf = new RandomAccessFile(ruta, "r")){
            long numeroRegistros = raf.length() / tamano_registro; 
            for (int i = 0; i< numeroRegistros; i++){
                raf.seek(i*tamano_registro); //no posicionamos en el inicio del puntero
                //leemos los datos
                long id = raf.readLong(); //id con un peso de 8 bytes

                StringBuilder sbDNI = new StringBuilder();
                for (int j = 0; j < Persona.MAX_LENGTH_DNI; j++){
                    sbDNI.append(raf.readChar());
                }
                String dni = sbDNI.toString().trim(); //dni con peso de 18 bytes

                int edad = raf.readInt(); //edad con peso de 4 bytes
                float salario = raf.readFloat(); //salario con peso de 4 bytes
                boolean borrado = raf.readBoolean(); //borrado con peso de 1 byte
                
                StringBuilder sbNombre = new StringBuilder();
                for (int j = 0; j < Persona.MAX_LENGTH_NOMBRE; j++){
                    sbNombre.append(raf.readChar());
                }
                String nombre = sbNombre.toString().trim(); //nombre con peso de 200 bytes
                
                //se crea el objeto persona con los datos leidos del archivo
                Persona persona = new Persona(id, dni, edad, salario, nombre);
                persona.setBorrado(borrado);
                //se añade el objeto persona al arraylist
                personas.add(persona);
            }
        }catch(IOException ex){
            logger.log(Level.SEVERE, "Se ha producido una excepción: ", ex);
        }
        return personas;

    }

    /**
     * Obtén un obxecto Persona do arquivo sinalado en ruta
     *
     * @param posicion indica a posición que ocupa cada persoa comezando no 0: o
     * cero devolverá a primera persoa, o 1 a segunda persoa, etc.
     * @param ruta a ruta ao arquivo
     * @return o obxecto Persoa atopado nesa posición
     * @throws NotFoundPersonaException en caso de erro
     */
    public Persona leerPersona(int posicion, String ruta) throws NotFoundPersonaException {
        try(RandomAccessFile raf = new RandomAccessFile(ruta, "r")){
            long numeroRegistros = raf.length() / tamano_registro; 

            if (posicion < 0 || posicion >= numeroRegistros){
                throw new NotFoundPersonaException(posicion);
            }
            raf.seek(posicion*tamano_registro); //no posicionamos en el inicio del puntero
            //leemos los datos
            long id = raf.readLong(); //id con un peso de 8 bytes

            StringBuilder sbDNI = new StringBuilder();
            for (int j = 0; j < Persona.MAX_LENGTH_DNI; j++){
                sbDNI.append(raf.readChar());
            }
            String dni = sbDNI.toString().trim(); //dni con peso de 18 bytes

            int edad = raf.readInt(); //edad con peso de 4 bytes
            float salario = raf.readFloat(); //salario con peso de 4 bytes
            boolean borrado = raf.readBoolean(); //borrado con peso de 1 byte
            
            StringBuilder sbNombre = new StringBuilder();
            for (int j = 0; j < Persona.MAX_LENGTH_NOMBRE; j++){
                sbNombre.append(raf.readChar());
            }
            String nombre = sbNombre.toString().trim(); //nombre con peso de 200 bytes
            Persona persona = new Persona(id, dni, edad, salario, nombre);
            persona.setBorrado(borrado);
            
            return persona;
        }catch(IOException ex){
            throw new NotFoundPersonaException(posicion);
        }
    }   
}
