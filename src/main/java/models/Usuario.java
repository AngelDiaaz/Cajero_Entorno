package models;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String dni;
	private ArrayList<Cuentas> cuentas;
	
	public Usuario(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.cuentas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public ArrayList<Cuentas> getCuentas() {
		return cuentas;
	}
	
	public void anndirCuenta(Cuentas cuenta) {
		this.cuentas.add(cuenta);
	}
}
