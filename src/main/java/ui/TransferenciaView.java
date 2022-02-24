package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import models.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import almacen.Almacen;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferenciaView {

	private JFrame frame;
	private JTextField txtNCuenta;
	private JTextField txtImporte;
	private JLabel lblNcuenta;
	private JLabel lblImporte;
	private JButton btnIngresar;
	private JButton btnAtras;

	/**
	 * Create the application.
	 */
	public TransferenciaView(Usuario usuario) {
		initialize(usuario);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario usuario) {
		frame = new JFrame();
		frame.setBounds(100, 100, 655, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNcuenta = new JLabel("Nº Cuenta");
		lblNcuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNcuenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNcuenta.setBounds(89, 92, 103, 23);
		frame.getContentPane().add(lblNcuenta);
		
		lblImporte = new JLabel("Importe");
		lblImporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImporte.setBounds(89, 156, 103, 23);
		frame.getContentPane().add(lblImporte);
		
		txtNCuenta = new JTextField();
		txtNCuenta.setBounds(238, 94, 333, 19);
		frame.getContentPane().add(txtNCuenta);
		txtNCuenta.setColumns(10);
		
		txtImporte = new JTextField();
		txtImporte.setColumns(10);
		txtImporte.setBounds(238, 158, 333, 19);
		frame.getContentPane().add(txtImporte);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNCuenta.getText().isEmpty() || txtImporte.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(btnIngresar, "Rellene todos los campos");
				}
				else
				{
					boolean valido = false;
					try {
						for (int i = 0; i < Almacen.listacuentas.size(); i++) {
							if(Integer.parseInt(txtNCuenta.getText())==Almacen.listacuentas.get(i).getNcuenta())
							{
								valido = true;
								break;
							}
						}
					} catch (Exception E)
					{
						valido = false;
					}
					
					if(valido)
					{
						if(Integer.parseInt(txtImporte.getText())>usuario.getCuenta().getSaldo())
						{
							JOptionPane.showMessageDialog(btnIngresar, "No tiene suficiente dinero");
						}
						else
						{
							usuario.getCuenta().transferencia(Double.parseDouble(txtImporte.getText()), Integer.parseInt(txtNCuenta.getText()));
							frame.dispose();
							CuentaView window = new CuentaView(usuario);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(btnIngresar, "Introduzaca un numero de cuenta valido");
					}
				}
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIngresar.setBounds(380, 269, 144, 31);
		frame.getContentPane().add(btnIngresar);
		
		btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CuentaView window = new CuentaView(usuario);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(190, 269, 144, 31);
		frame.getContentPane().add(btnAtras);
		
		
	}
}
