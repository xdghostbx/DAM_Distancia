import java.io.*;

import java.net.*;

class Cliente {

    static final String HOST = "localhost";

    static final int Puerto=2000;

    public Cliente( ) {

        try{

              Socket sCliente = new Socket( HOST , Puerto );

     InputStream aux = sCliente.getInputStream();

     DataInputStream flujo_entrada = new DataInputStream( aux );

     System.out.println( flujo_entrada.readUTF() );

     sCliente.close();

        } catch( Exception e ) {

     System.out.println( e.getMessage() );

        }

    }

    public static void main( String[] arg ) {

     new Cliente();

    }

}
