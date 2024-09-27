package codigoPlataforma31;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiaFicheros {



   public static void main(String args[]) {
      // Copiar ficheros
      File origen = new File("origen.txt");
      File destino = new File("destino.txt");
      try {
         InputStream in = new FileInputStream(origen);
         OutputStream out = new FileOutputStream(destino);
         byte[] buf = new byte[1024];
         int len;
         while ((len = in.read(buf)) > 0) {
           out.write(buf, 0, len);
        }
        in.close();
        out.close();
     } catch (IOException ioe) {
       ioe.printStackTrace();
     }
   }
}


