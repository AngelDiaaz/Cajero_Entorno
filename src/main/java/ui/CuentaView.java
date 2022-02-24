package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import models.Cuentas;
import models.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuentaView {

	private JFrame frame;
	private JLabel lblBienvenida;
	private JButton btnIngresar;
	private JButton btnTransferencia;
	private JButton btnRetirar;
	private JLabel lblDinero;
	private JButton btnAtrás;

	/**
	 * Create the application.
	 */
	public CuentaView(Usuario usuario) {
		initialize(usuario);
		mostrarDatos(usuario);
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario usuario) {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblBienvenida = new JLabel("Bienvenido "+usuario.getNombre());
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(10, 22, 621, 29);
		frame.getContentPane().add(lblBienvenida);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valido=true;
				double cantidad=0;
				try {
					cantidad=Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad a ingresar"));
				}catch(Exception E)
				{
					valido=false;
				}
				if(valido && cantidad>0)
				{
					usuario.getCuenta().ingresar(cantidad);
					mostrarDatos(usuario);
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnIngresar, "Introduzca una cantidad válida");
				}
				
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIngresar.setBounds(173, 279, 146, 29);
		frame.getContentPane().add(btnIngresar);
		
		btnTransferencia = new JButton("Transferencia");
		btnTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TransferenciaView window = new TransferenciaView(usuario);
			}
		});
		btnTransferencia.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTransferencia.setBounds(485, 279, 146, 29);
		frame.getContentPane().add(btnTransferencia);
		
		btnRetirar = new JButton("Retirar");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean valido=true;
				double cantidad=0;
				try {
					cantidad=Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad a retirar"));
				}catch(Exception E)
				{
					valido=false;
				}
				if(valido && cantidad>0 && cantidad<usuario.getCuenta().getSaldo())
				{
					usuario.getCuenta().retirar(cantidad);
					mostrarDatos(usuario);
					
				}
				else
				{
					JOptionPane.showMessageDialog(btnIngresar, "Introduzca una cantidad válida");
				}
			}
		});
		btnRetirar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRetirar.setBounds(329, 279, 146, 29);
		frame.getContentPane().add(btnRetirar);
		
		lblDinero = new JLabel();
		lblDinero.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinero.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblDinero.setBounds(10, 74, 621, 169);
		frame.getContentPane().add(lblDinero);
		
		btnAtrás = new JButton("Atrás");
		btnAtrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login =new Login();
			}
		});
		btnAtrás.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtrás.setBounds(17, 279, 146, 29);
		frame.getContentPane().add(btnAtrás);
	}
	
	private void mostrarDatos(Usuario usuario)
	{
		lblDinero.setText(String.valueOf(usuario.getCuenta().getSaldo())+" €");
	}
}
