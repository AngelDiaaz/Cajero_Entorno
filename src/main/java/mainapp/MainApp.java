package mainapp;

import almacen.Almacen;
import ui.Login;

public class MainApp {

	public static void main(String[] args) {
		Almacen.usuario1.setCuenta(Almacen.cuenta1);
		Almacen.usuario2.setCuenta(Almacen.cuenta2);
		Almacen.listacuentas.add(Almacen.cuenta1);
		Almacen.listacuentas.add(Almacen.cuenta2);
		
		Login window = new Login();

	}

}
