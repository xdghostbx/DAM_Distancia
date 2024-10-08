/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package di01_reservascoche;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class CocheElectrico extends javax.swing.JDialog {

    /**
     * Creates new form CocheElectrico
     */
    public CocheElectrico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        separador1 = new javax.swing.JSeparator();
        panelDatosPersonales = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        labelApellidos = new javax.swing.JLabel();
        apellidos = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        labelDNI = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        panelDatosReserva = new javax.swing.JPanel();
        labelFechaInicio = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JSpinner();
        labelFechaFin = new javax.swing.JLabel();
        fechaFin = new javax.swing.JSpinner();
        labelTipoVehiculo = new javax.swing.JLabel();
        tipoVehiculo = new javax.swing.JComboBox<>();
        labelEdadConductor = new javax.swing.JLabel();
        edadConductor = new javax.swing.JTextField();
        cableCarga = new javax.swing.JCheckBox();
        labelNumeroKilometros = new javax.swing.JLabel();
        numeroKilometros = new javax.swing.JTextField();
        labelExtras = new javax.swing.JLabel();
        extras = new javax.swing.JScrollPane();
        listaExtras = new javax.swing.JList<>();
        cancelar = new javax.swing.JButton();
        reservar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Coche eléctrico");
        setResizable(false);

        labelTitulo.setFont(new java.awt.Font("Wide Latin", 0, 30)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Coche eléctrico");
        labelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelTitulo.setName(""); // NOI18N

        panelDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        panelDatosPersonales.setToolTipText("Datos personales");

        labelNombre.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelNombre.setLabelFor(nombre);
        labelNombre.setText("Nombre:");
        labelNombre.setToolTipText("");

        nombre.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        nombre.setToolTipText("Escribe tu nombre");

        labelApellidos.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelApellidos.setLabelFor(apellidos);
        labelApellidos.setText("Apellidos:");

        apellidos.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        apellidos.setToolTipText("Escribe tus apellidos");

        labelTelefono.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelTelefono.setLabelFor(telefono);
        labelTelefono.setText("Teléfono:");

        telefono.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        telefono.setToolTipText("Escribe tu teléfono");

        labelDNI.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelDNI.setLabelFor(dni);
        labelDNI.setText("DNI / CIF:");

        dni.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        dni.setToolTipText("Escribe tu DNI / CIF");

        javax.swing.GroupLayout panelDatosPersonalesLayout = new javax.swing.GroupLayout(panelDatosPersonales);
        panelDatosPersonales.setLayout(panelDatosPersonalesLayout);
        panelDatosPersonalesLayout.setHorizontalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelNombre)
                    .addComponent(labelApellidos)
                    .addComponent(labelTelefono)
                    .addComponent(labelDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosPersonalesLayout.setVerticalGroup(
            panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosPersonalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelApellidos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDNI))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDatosReserva.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        panelDatosReserva.setToolTipText("Información sobre el vehículo");

        labelFechaInicio.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelFechaInicio.setLabelFor(fechaInicio);
        labelFechaInicio.setText("Fecha de inicio:");

        fechaInicio.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        fechaInicio.setModel(new javax.swing.SpinnerDateModel());
        fechaInicio.setToolTipText("Indique la fecha de inicio de su reserva");
        fechaInicio.setEditor(new javax.swing.JSpinner.DateEditor(fechaInicio, "dd/MM/yy"));
        fechaInicio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaInicioPropertyChange(evt);
            }
        });

        labelFechaFin.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelFechaFin.setLabelFor(fechaFin);
        labelFechaFin.setText("Fecha de fin:");

        fechaFin.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        fechaFin.setModel(new javax.swing.SpinnerDateModel());
        fechaFin.setToolTipText("Indique la fecha de fin de su reserva");
        fechaFin.setEditor(new javax.swing.JSpinner.DateEditor(fechaFin, "dd/MM/yy"));

        labelTipoVehiculo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelTipoVehiculo.setLabelFor(tipoVehiculo);
        labelTipoVehiculo.setText("Tipo de vehículo:");

        tipoVehiculo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        tipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compacto", "Berlina", "SUV", "Deportivo", "Tesla" }));
        tipoVehiculo.setToolTipText("Seleccione el tipo de vehículo deseado");
        tipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoVehiculoActionPerformed(evt);
            }
        });

        labelEdadConductor.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelEdadConductor.setLabelFor(edadConductor);
        labelEdadConductor.setText("Edad del conductor:");
        labelEdadConductor.setEnabled(false);

        edadConductor.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        edadConductor.setToolTipText("Indique la edad del conductor");
        edadConductor.setEnabled(false);

        cableCarga.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        cableCarga.setText("Solicitar cable de carga");
        cableCarga.setToolTipText("Marque esta casilla si necesita cable de carga");
        cableCarga.setEnabled(false);

        labelNumeroKilometros.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelNumeroKilometros.setLabelFor(numeroKilometros);
        labelNumeroKilometros.setText("Nº de kilómetros:");

        numeroKilometros.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        numeroKilometros.setToolTipText("Introduzca el número de kilometros a realizar");

        labelExtras.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        labelExtras.setLabelFor(extras);
        labelExtras.setText("Servicios extras:");

        listaExtras.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        listaExtras.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Cadenas", "Silla para bebé", "Seguro a todo riesgo", "Cancelación gratuita", "No precisa" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaExtras.setToolTipText("Seleccione los servicios extras que desea contratar");
        extras.setViewportView(listaExtras);

        javax.swing.GroupLayout panelDatosReservaLayout = new javax.swing.GroupLayout(panelDatosReserva);
        panelDatosReserva.setLayout(panelDatosReservaLayout);
        panelDatosReservaLayout.setHorizontalGroup(
            panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelExtras)
                    .addComponent(labelNumeroKilometros)
                    .addComponent(labelEdadConductor)
                    .addComponent(labelFechaInicio)
                    .addComponent(labelTipoVehiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosReservaLayout.createSequentialGroup()
                        .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edadConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosReservaLayout.createSequentialGroup()
                                .addComponent(labelFechaFin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cableCarga))
                        .addGap(75, 75, 75))
                    .addGroup(panelDatosReservaLayout.createSequentialGroup()
                        .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(extras, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelDatosReservaLayout.setVerticalGroup(
            panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosReservaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFechaInicio)
                    .addComponent(labelFechaFin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipoVehiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edadConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cableCarga)
                    .addComponent(labelEdadConductor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumeroKilometros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(extras, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelExtras))
                .addContainerGap())
        );

        cancelar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.setToolTipText("Salir del formulario de reserva");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        reservar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        reservar.setText("RESERVAR");
        reservar.setToolTipText("Aceptas realizar la reserva indicada");
        reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separador1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addGap(272, 272, 272)
                        .addComponent(reservar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelDatosPersonales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDatosReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reservar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoVehiculoActionPerformed
        if (tipoVehiculo.getSelectedIndex()==4) //Mostramos las opcines particulares para los tesla
        {
            labelEdadConductor.setEnabled(true);
            edadConductor.setEnabled(true);
            cableCarga.setEnabled(true);
        } else
        {
            labelEdadConductor.setEnabled(false);
            edadConductor.setEnabled(false);
            edadConductor.setText("");
            cableCarga.setEnabled(false);
            cableCarga.setSelected(false);
        }
    }//GEN-LAST:event_tipoVehiculoActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        setVisible(false);  //Volver al menú principal
    }//GEN-LAST:event_cancelarActionPerformed

    private void reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Su coche eléctrico ha sido reservado con éxito!"); //Mostrar mensaje
        setVisible(false);  //Volver al menú principal
    }//GEN-LAST:event_reservarActionPerformed

    private void fechaInicioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaInicioPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaInicioPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CocheElectrico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CocheElectrico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CocheElectrico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CocheElectrico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CocheElectrico dialog = new CocheElectrico(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos;
    private javax.swing.JCheckBox cableCarga;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField edadConductor;
    private javax.swing.JScrollPane extras;
    private javax.swing.JSpinner fechaFin;
    private javax.swing.JSpinner fechaInicio;
    private javax.swing.JLabel labelApellidos;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelEdadConductor;
    private javax.swing.JLabel labelExtras;
    private javax.swing.JLabel labelFechaFin;
    private javax.swing.JLabel labelFechaInicio;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNumeroKilometros;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTipoVehiculo;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JList<String> listaExtras;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField numeroKilometros;
    private javax.swing.JPanel panelDatosPersonales;
    private javax.swing.JPanel panelDatosReserva;
    private javax.swing.JButton reservar;
    private javax.swing.JSeparator separador1;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipoVehiculo;
    // End of variables declaration//GEN-END:variables
}
