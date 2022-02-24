package almacen;

import java.util.ArrayList;

import models.*;

public class Almacen {
	static public Usuario usuario1 = new Usuario("Angel Díaz", "11111111A");
	static public Cuentas cuenta1 = new Cuentas(0001, 1234, usuario1);
	static public Usuario usuario2 = new Usuario("Gabriel Morales", "22222222B");
	static public Cuentas cuenta2 = new Cuentas(0002, 4321, usuario2);
	static public ArrayList<Cuentas> listacuentas = new ArrayList<>();
	
	
}
