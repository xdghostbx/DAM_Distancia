/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos.EleccionesMunicipales;

/**
 *
 * @author USER
 */
public class Principal {

    static final int num_habitantes = 10000;
    static String[] nombresPartidos = {"PP","PSOE","SALF","VOX","Podemos"};
    
    public static void main(String[] args) {
        Urna urna = new Urna (nombresPartidos);
        
        Votante[] votantes = new Votante[num_habitantes];
        for(int i = 0; i<num_habitantes;i++){
            votantes[i] = new Votante(urna);
            votantes[i].start();
        }
        
        for (Votante votante : votantes){
            try{
                votante.join();
            } catch (InterruptedException e){}
        }
        System.out.println(urna);
        urna.visualizarResultados();
    }
    
}
