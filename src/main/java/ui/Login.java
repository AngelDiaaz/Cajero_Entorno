package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import almacen.Almacen;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtDni;
	private JLabel lblDNI;
	private JLabel lblPIN;
	private JLabel lblNewLabel_2;
	private JPasswordField passPIN;
	private JButton btnLogin;

	public Login() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblDNI = new JLabel("DNI");
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDNI.setBounds(109, 121, 110, 34);
		frame.getContentPane().add(lblDNI);

		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.CENTER);
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDni.setBounds(229, 118, 314, 37);
		frame.getContentPane().add(txtDni);
		txtDni.setColumns(10);

		lblPIN = new JLabel("PIN");
		lblPIN.setHorizontalAlignment(SwingConstants.CENTER);
		lblPIN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPIN.setBounds(109, 201, 110, 34);
		frame.getContentPane().add(lblPIN);

		lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(109, 25, 434, 34);
		frame.getContentPane().add(lblNewLabel_2);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int pin = 0;
				boolean valido = true;
				try {
					pin = Integer.parseInt(String.valueOf(passPIN.getPassword()));
				} catch (Exception E) {
					valido = false;
				}
				if (valido && pin < 10000 && pin > 999) {
					String usu = txtDni.getText();
					comprobarDatos(pin, usu);
				} else {
					JOptionPane.showMessageDialog(btnLogin, "El pin debe ser 4 numeros");
				}

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(318, 275, 115, 34);
		frame.getContentPane().add(btnLogin);

		passPIN = new JPasswordField();
		passPIN.setHorizontalAlignment(SwingConstants.CENTER);
		passPIN.setFont(new Font("Tahoma", Font.BOLD, 15));
		passPIN.setBounds(229, 201, 314, 34);
		frame.getContentPane().add(passPIN);
	}

	public boolean comprobarDatos(int pin, String usu) {
		if (Almacen.usuario1.getCuenta().getPin() == pin && Almacen.usuario1.getDni().equals(usu)) {
			CuentaView window = new CuentaView(Almacen.usuario1);
			frame.dispose();
			return true;
		} else if (Almacen.usuario2.getCuenta().getPin() == pin && Almacen.usuario2.getDni().equals(usu)) {
			CuentaView window = new CuentaView(Almacen.usuario2);
			frame.dispose();
			return true;
		} else {
			JOptionPane.showMessageDialog(btnLogin,
					"No se encuentra este usuario en el sistema o el pin es incorrecto");
			return false;
		}
	}
}
