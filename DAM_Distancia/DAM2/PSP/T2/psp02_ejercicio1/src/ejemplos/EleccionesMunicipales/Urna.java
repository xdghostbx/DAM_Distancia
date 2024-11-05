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
    
    public void vota(int numPartido){
        partidos[numPartido].votar();
    }
    
    public void visualizarResultados(){
        ArrayList<Partido> ganadores = new ArrayList();
        ganadores.add(partidos[0]);
        int totalVotos = partidos[0].getVotos();
        for(int i = 0; i<getNumPartidos();i++){
            int numVotosPartidoActual = partidos[i].getVotos();
            int numVotosPartidoGanador = ganadores.get(0).getVotos();
            if(numVotosPartidoActual >= numVotosPartidoGanador){
                if(numVotosPartidoActual > numVotosPartidoGanador){
                    ganadores.clear();
                }
                ganadores.add(partidos[i]);
            }
            totalVotos += numVotosPartidoActual;
        }
        
        System.out.println("\nTotal" + totalVotos+" votos emitidos");
        if(ganadores.size()==1){
            System.out.println("Ganador: "+ganadores.get(0));
        }else {
            System.out.println("Empate: "+ganadores);
        }
    }
    
    
}
