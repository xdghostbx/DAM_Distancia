package com.example.hibernate;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.example.hibernate.model.AccMovement;
import com.example.hibernate.model.Account;
import com.example.hibernate.model.Empleado;
import com.example.hibernate.model.servicio.AccountServicio;
import com.example.hibernate.model.servicio.EmpleadoServicio;
import com.example.hibernate.model.servicio.IAccountServicio;
import com.example.hibernate.model.servicio.IEmpleadoServicio;

public class AccountWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextArea mensajes_text_Area;
	private JList<Account> JListAllAccounts;

	private IEmpleadoServicio empleadoServicio;
	private IAccountServicio accountServicio;

	private CreateUpdateAccountDialog createDialog;
	private JButton btnModificarImporteCuenta;
	private JButton btnEliminarCuenta;
	private JTextField JtextFieldEmpno;
	private JLabel lblEmpno;

	private Empleado empleado = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountWindow frame = new AccountWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccountWindow() {

		empleadoServicio = new EmpleadoServicio();
		accountServicio = new AccountServicio();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(8, 8, 821, 707);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 450, 669, 228);
		panel.add(scrollPane);

		mensajes_text_Area = new JTextArea();
		scrollPane.setViewportView(mensajes_text_Area);
		mensajes_text_Area.setEditable(false);
		mensajes_text_Area.setText("Panel de mensajes");
		mensajes_text_Area.setForeground(new Color(255, 0, 0));
		mensajes_text_Area.setFont(new Font("Monospaced", Font.PLAIN, 13));

		JButton btnShowAllAccounts = new JButton("Mostrar cuentas");

		btnShowAllAccounts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShowAllAccounts.setBounds(38, 132, 208, 36);
		panel.add(btnShowAllAccounts);

		JScrollPane scrollPanel_in_JlistAllAccounts = new JScrollPane();
		panel.add(scrollPanel_in_JlistAllAccounts);

		btnModificarImporteCuenta = new JButton("Modificar importe cuenta");

		JListAllAccounts = new JList<Account>();

		JListAllAccounts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panel.add(JListAllAccounts);
		JListAllAccounts.setBounds(403, 37, 377, 362);

		JButton btnCrearNuevaAccount = new JButton("Crear nueva cuenta");

		btnCrearNuevaAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearNuevaAccount.setBounds(38, 201, 208, 36);
		panel.add(btnCrearNuevaAccount);

		btnModificarImporteCuenta.setEnabled(false);
		btnModificarImporteCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarImporteCuenta.setBounds(38, 266, 208, 36);
		panel.add(btnModificarImporteCuenta);

		btnEliminarCuenta = new JButton("Eliminar cuenta");

		btnEliminarCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminarCuenta.setEnabled(false);
		btnEliminarCuenta.setBounds(38, 342, 208, 36);
		panel.add(btnEliminarCuenta);

		lblEmpno = new JLabel("Introduzca el nº de empleado");
		lblEmpno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmpno.setBounds(35, 37, 243, 31);
		panel.add(lblEmpno);

		JtextFieldEmpno = new JTextField();
		JtextFieldEmpno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JtextFieldEmpno.setBounds(38, 77, 136, 36);
		panel.add(JtextFieldEmpno);
		JtextFieldEmpno.setColumns(10);
		JtextFieldEmpno.addKeyListener(null);

		// Eventos
		ActionListener showAllAccountsActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAllAccounts();
			}
		};
		btnShowAllAccounts.addActionListener(showAllAccountsActionListener);

		ActionListener crearListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int empno = getEmpnoFromTextField();
				try {

					if (empno != -1) {
						Account nuevaAcc = new Account();

						if ((AccountWindow.this.empleado == null)
								|| (empno != AccountWindow.this.empleado.getEmpno())) {

							AccountWindow.this.empleado = empleadoServicio.find(empno);
						}
						// Establezco la relación entre la nueva Account y el empleado
						nuevaAcc.setEmp(AccountWindow.this.empleado);
						JFrame owner = (JFrame) SwingUtilities.getRoot((Component) e.getSource());

						createDialog = new CreateUpdateAccountDialog(owner, "Crear nueva cuenta",
								Dialog.ModalityType.DOCUMENT_MODAL, nuevaAcc);
						showDialog(BigDecimal.ZERO);
					} else {
						addMensaje(true, "El número de empleado no es correcto");
					}
				} catch (Exception ex) {
					addMensaje(true, "El empno " + empno + " no se encontró");
				}
			}
		};
		btnCrearNuevaAccount.addActionListener(crearListener);

		ActionListener modificarListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIx = JListAllAccounts.getSelectedIndex();
				if (selectedIx > -1) {
					// Estas cuentas ya vienen con un proxy de su empleado y con su empno
					Account account = (Account) JListAllAccounts.getModel().getElementAt(selectedIx);
					if (account != null) {

						JFrame owner = (JFrame) SwingUtilities.getRoot((Component) e.getSource());

						createDialog = new CreateUpdateAccountDialog(owner, "Modificar importe cuenta",
								Dialog.ModalityType.DOCUMENT_MODAL, account);

						showDialog(account.getAmount());
					}
				}
			}
		};

		btnModificarImporteCuenta.addActionListener(modificarListener);

		ListSelectionListener selectionListListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false) {
					int selectedIx = JListAllAccounts.getSelectedIndex();
					btnModificarImporteCuenta.setEnabled((selectedIx > -1));
					btnEliminarCuenta.setEnabled((selectedIx > -1));

					if (selectedIx > -1) {
						Account accountd = (Account) JListAllAccounts.getModel().getElementAt(selectedIx);
						if (accountd != null) {
							addMensaje(true, "Se ha seleccionado la cuenta con id: " + accountd);
						}
					}
				}
			}
		};
		JListAllAccounts.addListSelectionListener(selectionListListener);

		ActionListener deleteListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIx = JListAllAccounts.getSelectedIndex();
				if (selectedIx > -1) {
					Account account = (Account) JListAllAccounts.getModel().getElementAt(selectedIx);
					if (account != null) {
						try {
							accountServicio.delete(account.getAccountno());

							addMensaje(true, "Se ha eliminado la cuenta con id: " + account.getAccountno());
							getAllAccounts();

						} catch (Exception ex) {
							addMensaje(true, "No se ha podido borrar la cuenta. ");
							System.out.println("Exception: " + ex.getMessage());
							ex.printStackTrace();
						}
					}
				}
			}
		};
		btnEliminarCuenta.addActionListener(deleteListener);

		KeyAdapter enterKeyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String textIntroducido = "";

				int key = e.getKeyCode();
				// Cuando se presiona la tecla enter, intentamos obtener el saldo de la cuenta
				if ((key == KeyEvent.VK_ENTER)) {

					textIntroducido = ((JTextField) e.getSource()).getText().trim();
					try {
						int accId = Integer.parseInt(textIntroducido);
						// Se guarda en un atributo de la clase
						AccountWindow.this.empleado = empleadoServicio.find(accId);

						if (empleado != null) {
							addMensaje(true, "Se ha encontrado el empleado con id: " + accId);
						}

					} catch (NumberFormatException nfe) {

						addMensaje(true, "Introduzca un número entero");
						AccountWindow.this.empleado = null;

				
					} catch (Exception ex) {
						System.out.println("Ha ocurrido una excepción: " + ex.getMessage());
						addMensaje(true, "Ha ocurrido un error y no se ha podido recuperar el empleado con id: "
								+ textIntroducido);
						AccountWindow.this.empleado = null;

					}
				}
			}

		};
		JtextFieldEmpno.addKeyListener(enterKeyAdapter);
	}

	private void addMensaje(boolean keepText, String msg) {
		String oldText = "";
		if (keepText) {
			oldText = mensajes_text_Area.getText();

		}
		oldText = oldText + "\n" + msg;
		mensajes_text_Area.setText(oldText);

	}

	private void showDialog(BigDecimal oldAmount) {
		createDialog.setVisible(true);
		Account cuentaACrearOActualizar = createDialog.getResult();
		if (cuentaACrearOActualizar != null) {
			if (cuentaACrearOActualizar.getAccountno() != null) {
				// update
				update(cuentaACrearOActualizar, oldAmount);
			} else
				save(cuentaACrearOActualizar);
		}
	}

	private void update(Account cuenta, BigDecimal oldAmount) {
		addMensaje(true, "La diferencia entre importes es: old:" + oldAmount + " new: " + cuenta.getAmount());
		BigDecimal diferencia = oldAmount.subtract(cuenta.getAmount());
		// oldAmount < cantidad actual, diferencia es negativa-> se ha ingresado dinero
		// +diferencia
		// oldAmount > cantidad actual, diferencia es positiva-> se ha retirado dinero
		// -diferencia
		// si cantidades iguales no hacemos nada
		// En el movimiento hay que invertir los signos

		if (diferencia.compareTo(BigDecimal.ZERO) != 0) {
			try {
				AccMovement movimiento = accountServicio.autoTransferir(cuenta.getAccountno(),
						diferencia.doubleValue() * (-1));
				
				getAllAccounts();
				addMensaje(true, "Se ha creado el movimiento: " + movimiento);

		
			} catch (Exception e2) {
				addMensaje(true, "No se ha podido modificar la cuenta con número: " + cuenta.getAccountno());

			}
		} else {
			addMensaje(true, "No ha habido variación de cantidad en la cuenta" + cuenta.getAccountno());
		}

	}

	private void save(Account cuenta) {
		try {
			 accountServicio.crear(cuenta);
		
				addMensaje(true, "Se ha creado una cuenta con id: " + cuenta.getAccountno());
				getAllAccounts();
			

		} catch (Exception ex) {
			addMensaje(true, "Ha ocurrido un error y no se ha podido crear la cuenta");
		}
	}

	private void getAllAccounts() {
		int empno = getEmpnoFromTextField();
		if (empno != -1) {
			try {
				List<Account> accounts = accountServicio.getAccountsByEmpno(empno);
				addMensaje(true, "Se han recuperado: " + accounts.size() + " cuentas");
				DefaultListModel<Account> defModel = new DefaultListModel<>();

				defModel.addAll(accounts);

				JListAllAccounts.setModel(defModel);
			} catch (Exception ex) {
				addMensaje(true, "Ha habido un error y no se han podido recuperar las cuentas del empleado: " + empno);
			}
		} else {
			addMensaje(true, "El número de empleado no es correcto");
		}

	}

	private int getEmpnoFromTextField() {
		int empno = -1;
		String textIntroducido = JtextFieldEmpno.getText().trim();
		try {
			empno = Integer.parseInt(textIntroducido);
		} catch (Exception nfe) {
			empno = -1;
		}
		return empno;
	}
}