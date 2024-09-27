package codigoPlataforma31;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopiaFicherosTryWithResources {



   public static void main(String args[]) {
     
      try(
         InputStream in = new FileInputStream(new File("origen.txt"));
         OutputStream out = new FileOutputStream(new File("destino.txt"));){
         byte[] buf = new byte[1024];
         int len;
         while ((len = in.read(buf)) > 0) {
           out.write(buf, 0, len);
        }
       
     } catch (IOException ioe) {
       ioe.printStackTrace();
     }
   }
}


