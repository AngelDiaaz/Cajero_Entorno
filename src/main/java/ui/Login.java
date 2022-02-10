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
	private JButton btnRegistro;
	
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
				boolean valido = true;
				
				try
				{
					int numero = Integer.parseInt(String.valueOf(passPIN.getPassword()));
				} catch(Exception x){
					valido=false;
				}
				
				if(valido==false)
				{
					JOptionPane.showMessageDialog(btnLogin, "El PIN debe ser unicamente números");
				}
				
				else if(String.valueOf(passPIN.getPassword()).length()>4 || String.valueOf(passPIN.getPassword()).length()>4)
				{
					JOptionPane.showMessageDialog(btnLogin, "El numero pin debe ser exactamente 4 números");
				}
				
				else
				{
					for (int i = 0; i < Almacen.usuariosSistema.size(); i++) {
						if(Almacen.usuariosSistema.get(i).equals(txtDni.getText()))
						{
							for (int j = 0; j < Almacen.usuariosSistema.get(i).getCuentas().size(); j++) {
								if(Almacen.usuariosSistema.get(i).getCuentas().get(j).equals(String.valueOf(passPIN.getPassword())))
								{
									frame.setVisible(false);
									CuentaView window = new CuentaView(Almacen.usuariosSistema.get(i).getCuentas().get(j));
									break;
								}
								if(j==Almacen.usuariosSistema.get(i).getCuentas().size()-1 && !Almacen.usuariosSistema.get(i).getCuentas().get(j).equals(String.valueOf(passPIN.getPassword())))
								{
									JOptionPane.showMessageDialog(btnLogin, "Este usuario no tiene ninguna cuenta asociada a este pin");
									break;
								}
							}
						}
						if(i==Almacen.usuariosSistema.size()-1 && !Almacen.usuariosSistema.get(i).equals(txtDni.getText()))
						{
							JOptionPane.showMessageDialog(btnLogin, "No se encuentra este usuario en la base de datos");
							break;
						}
					}
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(229, 276, 115, 34);
		frame.getContentPane().add(btnLogin);
		
		passPIN = new JPasswordField();
		passPIN.setHorizontalAlignment(SwingConstants.CENTER);
		passPIN.setFont(new Font("Tahoma", Font.BOLD, 15));
		passPIN.setBounds(229, 201, 314, 34);
		frame.getContentPane().add(passPIN);
		
		btnRegistro = new JButton("Registrar Cuenta");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RegisterView window = new RegisterView();
			}
		});
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistro.setBounds(382, 274, 161, 37);
		frame.getContentPane().add(btnRegistro);
	}
}
