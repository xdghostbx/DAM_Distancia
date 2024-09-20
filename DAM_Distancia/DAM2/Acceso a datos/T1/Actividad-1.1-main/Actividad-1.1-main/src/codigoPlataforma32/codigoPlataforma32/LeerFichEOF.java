package codigoPlataforma32;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichEOF {
	public static void main(String args[]) throws IOException {


		BufferedReader br = new BufferedReader(new FileReader("DAM_Distancia_1\\DAM_Distancia\\DAM2\\Acceso a datos\\T1\\Actividad-1.1-main\\Actividad-1.1-main\\origen.txt"));
		int codigo = br.read();// lee el primer caracter
		char caracter;
		// mientras el código no sea -1 (EOF) continuo leyendo
		while (codigo != -1) {
			caracter = (char) codigo; // casting
			System.out.print(caracter);
			codigo = br.read(); // lee un caracter
		}
		//Añadido con respecto al código de la plataforma
		if (br != null) {
			br.close();
		}
	}
}
