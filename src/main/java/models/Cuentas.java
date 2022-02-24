package models;

import almacen.Almacen;

public class Cuentas {
	private int ncuenta;
	private int pin;
	private double saldo;
	private Usuario duenno;
	
	public Cuentas(int ncuenta, int pin, Usuario duenno) {
		super();
		this.ncuenta = ncuenta;
		this.pin = pin;
		this.duenno = duenno;
	}

	public int getNcuenta() {
		return ncuenta;
	}

	public int getPin() {
		return pin;
	}

	public double getSaldo() {
		return saldo;
	}

	public Usuario getDuenno() {
		return duenno;
	}
	
	public void retirar(double retiro) {
			this.saldo-=retiro;
	}
	
	public void ingresar(double ingreso) {
		this.saldo+=ingreso;
	}
	
	public void transferencia(double dinero, int numero_cuenta)
	{
		for (int i = 0; i < Almacen.listacuentas.size(); i++) {
			if(Almacen.listacuentas.get(i).getNcuenta() == numero_cuenta) {
				this.retirar(dinero);
				Almacen.listacuentas.get(i).ingresar(dinero);
			}
		}
	}
	
	
}
