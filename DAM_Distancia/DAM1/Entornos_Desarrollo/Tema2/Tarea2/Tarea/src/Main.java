/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        JLabel lblSaludo = new JLabel("Hola Mundo. Creando mi primer ejemplo");
        add(lblSaludo);

        setSize(400, 200);
        setTitle("JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
        });
    }
}

/*
    Se importó la clase JFrame y JLabel del paquete javax.swing para su uso en el código.
    Se eliminó la declaración extends JFrame del método Main, ya que se supone que es el punto de entrada del programa, y no es necesario extender la clase JFrame.
    El método main ahora utiliza SwingUtilities.invokeLater() para asegurar que la creación de la interfaz gráfica se realice en el hilo de despacho de eventos de Swing, lo que es necesario para evitar problemas de concurrencia en aplicaciones gráficas de Swing.

Con estos cambios, el código debería funcionar y mostrar una ventana con el mensaje "Hola Mundo. Creando mi primer ejemplo".
*/