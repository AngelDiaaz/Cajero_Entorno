package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegisterView {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JPasswordField passPIN;

	/**
	 * Create the application.
	 */
	public RegisterView() {
		
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 617, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombre.setBounds(34, 71, 146, 29);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDNI.setBounds(34, 110, 146, 29);
		frame.getContentPane().add(lblDNI);
		
		JLabel lblNumero = new JLabel("Numero de cuenta");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumero.setBounds(34, 149, 146, 32);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblPIN = new JLabel("PIN");
		lblPIN.setHorizontalAlignment(SwingConstants.CENTER);
		lblPIN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPIN.setBounds(34, 191, 146, 30);
		frame.getContentPane().add(lblPIN);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(206, 71, 262, 28);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(206, 110, 262, 28);
		frame.getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		passPIN = new JPasswordField();
		passPIN.setBounds(206, 191, 262, 29);
		frame.getContentPane().add(passPIN);
		
		JLabel lblNumeroCuenta = new JLabel("");
		lblNumeroCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroCuenta.setBounds(206, 149, 262, 32);
		frame.getContentPane().add(lblNumeroCuenta);
	}

}
