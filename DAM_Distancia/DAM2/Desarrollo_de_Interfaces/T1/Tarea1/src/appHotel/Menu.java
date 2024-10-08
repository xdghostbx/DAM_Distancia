/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package appHotel;

import javax.swing.JOptionPane;

/**
 *
 * @author xdGHOSTbx
 */
public class Menu extends javax.swing.JFrame {

  /**
   * Creates new form Menu
   */
  public Menu() {
    initComponents();
  }
  //titulo por defecto para el cuadro de dialogo de las opciones sin funcionalidad
  String tituloAlarma = "";
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BTCuba = new javax.swing.JButton();
        BTHabana = new javax.swing.JButton();
        BTMadrid = new javax.swing.JButton();
        BTBarcelona = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        BTSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMArchivo = new javax.swing.JMenu();
        jMReseva = new javax.swing.JMenu();
        jMeReservarHotel = new javax.swing.JMenuItem();
        jMSobreNosotros = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(null);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(10, 40, 421, 10);

        jLabel1.setBackground(new java.awt.Color(153, 153, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Gestión Hotelera");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(110, 10, 205, 36);

        jPanel1.setOpaque(false);

        BTCuba.setBackground(new java.awt.Color(153, 153, 0));
        BTCuba.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BTCuba.setForeground(new java.awt.Color(51, 51, 51));
        BTCuba.setText("Salón Cuba");
        BTCuba.setToolTipText("reserva sala Cuba");
        BTCuba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCubaActionPerformed(evt);
            }
        });

        BTHabana.setBackground(new java.awt.Color(153, 153, 0));
        BTHabana.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BTHabana.setForeground(new java.awt.Color(51, 51, 51));
        BTHabana.setText("Salón Habana");
        BTHabana.setToolTipText("reserva sala Habana");
        BTHabana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTHabanaActionPerformed(evt);
            }
        });

        BTMadrid.setBackground(new java.awt.Color(153, 153, 0));
        BTMadrid.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BTMadrid.setForeground(new java.awt.Color(51, 51, 51));
        BTMadrid.setText("Salón Madrid");
        BTMadrid.setToolTipText("reserva sala Madrid");
        BTMadrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTMadridActionPerformed(evt);
            }
        });

        BTBarcelona.setBackground(new java.awt.Color(153, 153, 0));
        BTBarcelona.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BTBarcelona.setForeground(new java.awt.Color(51, 51, 51));
        BTBarcelona.setText("Salón Barcelona");
        BTBarcelona.setToolTipText("reserva sala Barcelona");
        BTBarcelona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTBarcelonaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTHabana, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTCuba, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTCuba, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTHabana, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTBarcelona, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTMadrid, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 50, 430, 144);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 190, 430, 3);

        BTSalir.setBackground(new java.awt.Color(153, 153, 0));
        BTSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTSalir.setForeground(new java.awt.Color(51, 51, 51));
        BTSalir.setText("Salir");
        BTSalir.setToolTipText("Salir de la aplcación");
        BTSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSalirActionPerformed(evt);
            }
        });
        jPanel2.add(BTSalir);
        BTSalir.setBounds(42, 200, 350, 27);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hotel_foto.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(-20, -10, 490, 280);

        jMArchivo.setText("Archivo");
        jMArchivo.setToolTipText("Opciones de la aplicaicon");
        jMArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMArchivoMouseClicked(evt);
            }
        });
        jMArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMArchivoActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMArchivo);

        jMReseva.setText("Reservas");
        jMReseva.setToolTipText("Seccion de reservas");

        jMeReservarHotel.setText("Reservar Hotel");
        jMeReservarHotel.setToolTipText("reserva sala Habana");
        jMeReservarHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMeReservarHotelActionPerformed(evt);
            }
        });
        jMReseva.add(jMeReservarHotel);

        jMenuBar1.add(jMReseva);

        jMSobreNosotros.setText("Sobre Nosotros");
        jMSobreNosotros.setToolTipText("Informacion sobre la cadena hotelera");
        jMSobreNosotros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSobreNosotrosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMSobreNosotros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jMArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMArchivoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jMArchivoActionPerformed

  private void jMArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMArchivoMouseClicked
    // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "Esta funcionalidad aun no está disponible", tituloAlarma, JOptionPane.WARNING_MESSAGE);
  }//GEN-LAST:event_jMArchivoMouseClicked

  private void jMSobreNosotrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMSobreNosotrosMouseClicked
    // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "Esta funcionalidad aun no está disponible", tituloAlarma, JOptionPane.WARNING_MESSAGE);
  }//GEN-LAST:event_jMSobreNosotrosMouseClicked

  private void BTCubaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCubaActionPerformed
    // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "Esta funcionalidad aun no está disponible", tituloAlarma, JOptionPane.WARNING_MESSAGE);
  }//GEN-LAST:event_BTCubaActionPerformed

  private void BTMadridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTMadridActionPerformed
    // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "Esta funcionalidad aun no está disponible", tituloAlarma, JOptionPane.WARNING_MESSAGE);
  }//GEN-LAST:event_BTMadridActionPerformed

  private void BTBarcelonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTBarcelonaActionPerformed
    // TODO add your handling code here:
    JOptionPane.showMessageDialog(this, "Esta funcionalidad aun no está disponible", tituloAlarma, JOptionPane.WARNING_MESSAGE);
  }//GEN-LAST:event_BTBarcelonaActionPerformed

  private void BTSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSalirActionPerformed
    // TODO add your handling code here:
    System.exit(0);
  }//GEN-LAST:event_BTSalirActionPerformed

  private void BTHabanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTHabanaActionPerformed
    // TODO add your handling code here:
    salonHabana newSalon = new salonHabana();
    newSalon.setVisible(true);
  }//GEN-LAST:event_BTHabanaActionPerformed

  private void jMeReservarHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMeReservarHotelActionPerformed
    // TODO add your handling code here:
    new salonHabana().setVisible(true);
  }//GEN-LAST:event_jMeReservarHotelActionPerformed

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
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Menu().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTBarcelona;
    private javax.swing.JButton BTCuba;
    private javax.swing.JButton BTHabana;
    private javax.swing.JButton BTMadrid;
    private javax.swing.JButton BTSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMArchivo;
    private javax.swing.JMenu jMReseva;
    private javax.swing.JMenu jMSobreNosotros;
    private javax.swing.JMenuItem jMeReservarHotel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
