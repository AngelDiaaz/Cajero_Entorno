package models;

import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String dni;
	private Cuentas cuenta;
	
	public Usuario(String nombre, String dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public Cuentas getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(Cuentas cuenta) {
		this.cuenta=cuenta;
	}
}
