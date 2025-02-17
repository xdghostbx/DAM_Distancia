import javax.swing.*;

public class Calculadora{
   
    public static void main(String[] args) {
        int coches = 0;
        String [][] concesionario = new String [50][4];
        for (int i = 0; i<3;i++){
            for (int j = 0; j<4;j++){
                if (j == 0){
                    concesionario[i][j] = JOptionPane.showInputDialog("Introduce marca "+ (i+1));
                }else if (j == 1){
                    concesionario[i][j] = JOptionPane.showInputDialog("Introduce matricula "+ (i+1));
                }else if (j == 2){
                    concesionario[i][j] = JOptionPane.showInputDialog("Introduce nombre "+ (i+1));
                }else if (j==3){
                    concesionario[i][j] = JOptionPane.showInputDialog("Introduce dni "+ (i+1));
                }
            }
        }
        
        for (int z = 0; z < 3;z++ ){
            System.out.println();
            for(int h = 0; h<4; h++){
                System.out.printf(concesionario[z][h]);
                System.out.print(" ");
            }
        }
    }
}
