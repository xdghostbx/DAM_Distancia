import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField numField1, numField2, resultField;
    private JButton sumButton, subButton, multButton, div;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel numLabel1 = new JLabel("Número 1:");
        numField1 = new JTextField();
        JLabel numLabel2 = new JLabel("Número 2:");
        numField2 = new JTextField();
        JLabel resultLabel = new JLabel("Resultado:");
        resultField = new JTextField();
        resultField.setEditable(false);

        sumButton = new JButton("Suma");
        subButton = new JButton("Resta");
        multButton = new JButton("Multiplica");
        div = new JButton("Divide");

        sumButton.addActionListener(this);
        subButton.addActionListener(this);
        multButton.addActionListener(this);
        div.addActionListener(this);

        panel.add(numLabel1);
        panel.add(numField1);
        panel.add(numLabel2);
        panel.add(numField2);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(sumButton);
        panel.add(subButton);
        panel.add(multButton);
        panel.add(div);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());

            if (e.getSource() == sumButton) {
                double result = num1 + num2;
                resultField.setText(String.valueOf(result));
            } else if (e.getSource() == subButton) {
                double result = num1 - num2;
                resultField.setText(String.valueOf(result));
            } else if (e.getSource() == multButton) {
                double result = num1 * num2;
                resultField.setText(String.valueOf(result));
            } else if (e.getSource() == div) {
                double result = num1 / num2;
                resultField.setText(String.valueOf(result));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculadora::new);
    }
}
