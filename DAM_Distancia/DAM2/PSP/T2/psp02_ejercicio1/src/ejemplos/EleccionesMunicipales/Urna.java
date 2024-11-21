/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.EleccionesMunicipales;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author USER
 */
public class Urna {
    Partido [] partidos;

    public Urna(String[] nombrePartidos) {
        partidos = new Partido [nombrePartidos.length];
        int numPartidos = 0;
        for (String nombrePartido : nombrePartidos){
            partidos[numPartidos++] = new Partido(nombrePartido);
        }
    }
    
    public int getNumPartidos(){
        return partidos.length;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(partidos);
    }
    
    public synchronized void vota(int numPartido){
        partidos[numPartido].votar();
    }
    
    public synchronized void visualizarResultados(){
        ArrayList<Partido> ganadores = new ArrayList();
        
        
        //int totalVotos = partidos[0].getVotos();
        int totalVotos = 0;
        int maxVotos = 0;
        for(int i = 0; i<partidos.length;i++){
            int numVotosPartidoActual = partidos[i].getVotos();
            if(numVotosPartidoActual > maxVotos){
                ganadores.clear();
                ganadores.add(partidos[i]);
                maxVotos = numVotosPartidoActual;
            } else if (numVotosPartidoActual == maxVotos){
                ganadores.add(partidos[i]);
            }
            
            totalVotos += numVotosPartidoActual;
        }
        
        System.out.println("\nTotal: " + totalVotos+" votos emitidos");
        if(ganadores.size()==1){
            System.out.println("Ganador: "+ganadores.get(0));
        }else {
            System.out.println("Empate: "+ganadores);
        }
    }
    
    
}
