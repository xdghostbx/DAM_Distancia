/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.EleccionesMunicipales;

/**
 *
 * @author USER
 */
public class Partido {
    private String nombre;
    private int votos;

    public Partido(String nombre) {
        this.nombre = nombre;
        this.votos = 0;
    }
    
    public int getVotos(){
        return votos;
    }

    @Override
    public String toString() {
        return  nombre + ", votos=" + votos + '}';
    }
    
    public synchronized void votar(){
        this.votos++;
    }
    
    
}
