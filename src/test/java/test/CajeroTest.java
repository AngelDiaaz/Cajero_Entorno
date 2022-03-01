package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import almacen.Almacen;
import ui.CuentaView;
import ui.Login;
import ui.TransferenciaView;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CajeroTest {

	@BeforeEach
	void Before() {
		Almacen.usuario1.setCuenta(Almacen.cuenta1);
		Almacen.usuario2.setCuenta(Almacen.cuenta2);
		Almacen.listacuentas.add(Almacen.cuenta1);
		Almacen.listacuentas.add(Almacen.cuenta2);
	}

	@BeforeAll
	public static void inicio() {
		System.out.println("*************** Inicio Prueba Comprobar Login ***************\n");
	}

	@AfterAll
	public static void fin() {
		System.out.println("\n*************** Fin Prueba Comprobar Login ***************");
	}
	
	/**
	 * Prueba de registrarse con un usuario
	 */

	@Test
	@Order(1)
	void comprobarUsuario() {
		Login login = new Login();

		int pin = 1234;
		String usu = "11111111A";
		String usu1 = "11111111B";

		assertTrue(login.comprobarDatos(pin, usu));
		assertFalse(login.comprobarDatos(pin, usu1));
	}
	
	/**
	 * Prueba de ingreso de dinero a cuenta bancaria
	 */

	@Test
	@Order(2)
	void comprobarIngreso() {
		int ingreso = 100;
		System.out.println("Saldo en la cuenta: " + Almacen.usuario1.getCuenta().getSaldo());
		System.out.println("Dinero a ingresar: " + ingreso);
		Almacen.usuario1.getCuenta().setSaldo(ingreso);

		assertEquals(ingreso, Almacen.usuario1.getCuenta().getSaldo());

		System.out.println("Saldo en la cuenta: " + Almacen.usuario1.getCuenta().getSaldo());
	}
	
	/**
	 * Prueba retirar dinero de la cuenta bancaria
	 */

	@Test
	@Order(3)
	void comprobarRetirar() {
		CuentaView cuenta = new CuentaView(Almacen.usuario1);

		int dineroRetirar = 50;
//		System.out.println("Saldo de la cuenta = " + Almacen.usuario1.getCuenta().getSaldo());
//		System.out.println("Dinero a retirar = " + dineroRetirar);
//		assertFalse(cuenta.comprobarRetirar(true, dineroRetirar, Almacen.usuario1));

		Almacen.usuario1.getCuenta().setSaldo(100);
		System.out.println("\nDinero a retirar = " + dineroRetirar);
		assertTrue(cuenta.comprobarRetirar(true, dineroRetirar, Almacen.usuario1));
		System.out.println("Saldo de la cuenta = " + Almacen.usuario1.getCuenta().getSaldo());
		System.out.println();
	}
	
	/**
	 * Prueba de la transferencia de una cuenta a otra
	 */

	@Test
	@Order(4)
	void comprobarTransferencia() {
		TransferenciaView cuenta = new TransferenciaView(Almacen.usuario1);

		String dineroTransferir = "30";

		System.out.println("Saldo cuenta1: " + Almacen.usuario1.getCuenta().getSaldo());
		System.out.println("Dinero a tranferir: " + dineroTransferir);
		System.out.println("Saldo cuenta2: " + Almacen.usuario2.getCuenta().getSaldo());
		boolean transfe = cuenta.transferencia(Almacen.usuario1, dineroTransferir,
				Almacen.usuario2.getCuenta().getNcuenta());
		assertTrue(transfe);
		// Hay un fallo a la hora de hacer la transferencia, ya que al realizar la
		// transferencia el dinero que le llega a la cuenta es multiplicado por 4
		assertEquals(Integer.parseInt(dineroTransferir), Almacen.usuario2.getCuenta().getSaldo());

		System.out.println("Saldo cuenta2: " + Almacen.usuario2.getCuenta().getSaldo());

	}
}
