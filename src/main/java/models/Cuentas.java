package models;

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
	
	public void transferencia(double dinero, Cuentas cuenta)
	{
		this.retirar(dinero);
		cuenta.ingresar(dinero);
	}
	
	
}
