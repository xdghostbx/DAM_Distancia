/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.EleccionesMunicipales;

import java.util.Random;

/**
 *
 * @author USER
 */
public class Votante extends Thread {
    Urna urna;
    static final int TIEMPO = 5;
    static Random random = new Random();
    
    public Votante(Urna urna){
        this.urna = urna;
    }
    
    @Override
    public void run(){
        try{
            Thread.sleep(random.nextInt(TIEMPO));
        }catch (InterruptedException e){}
        
        int numeroDePartido = random.nextInt(urna.getNumPartidos());
        urna.vota(numeroDePartido);
    }
}
