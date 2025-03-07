package com.example.hibernate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.hibernate.model.Account;

public class CreateUpdateAccountDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAmount;
	private JButton okButton;
	private JLabel lblError=null;

	private Account cuentaACrearOActualizar = null;

	public Account getResult() {
		return this.cuentaACrearOActualizar;
	}

	/**
	 * Create the dialog.
	 */
	public void initComponents() {

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblImporte = new JLabel("Importe cuenta");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImporte.setBounds(46, 76, 140, 24);
		contentPanel.add(lblImporte);

		textFieldAmount = new JTextField();
		textFieldAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldAmount.setBounds(215, 77, 197, 23);
		contentPanel.add(textFieldAmount);
		textFieldAmount.setColumns(10);

		lblError = new JLabel("Importe inicial");
		lblError.setVisible(false);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setBounds(33, 169, 379, 24);
		contentPanel.add(lblError);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("Guardar");

		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuentaACrearOActualizar = null;
				CreateUpdateAccountDialog.this.dispose();

			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		ActionListener crearBtnActionListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!(textFieldAmount.getText().trim().equals(""))) {
					try {
						BigDecimal cantidad = getAmountFromTextField();
						
						cuentaACrearOActualizar.setAmount(cantidad);
						CreateUpdateAccountDialog.this.dispose();
					} catch (Exception ex) {
						System.out.println("Ha ocurrido un problema obteniendo la cantidad: " + ex.getMessage());
						lblError.setText("La cantidad introducida no es correcta");
						lblError.setVisible(true);

					}

				}
			}
		};

		this.okButton.addActionListener(crearBtnActionListener);

	}

	public CreateUpdateAccountDialog(Window owner, String title, ModalityType modalityType, Account acc) {
		super(owner, title, modalityType);
		initComponents();
		cuentaACrearOActualizar = acc;
		lblError.setVisible(false);
		if (cuentaACrearOActualizar != null && cuentaACrearOActualizar.getAmount()!=null ) {

			textFieldAmount.setText(cuentaACrearOActualizar.getAmount().toString());

		}
		this.setLocationRelativeTo(owner);
	}

	private BigDecimal getAmountFromTextField() throws NumberFormatException {

		lblError.setVisible(false);
		String textIntroducido = textFieldAmount.getText().trim();

		return new BigDecimal(textIntroducido);

	}
}