package proyecto.hibernate.CRUDHibernate;

public class Utils {
	
	public static void mensajeInicial() {
		System.out.println("Cuenta con las siguiente opciones:");
		System.out.println("1. Añadir.");
		System.out.println("2. Mostrar.");
		System.out.println("3. Actualizar.");
		System.out.println("4. Borrar.");
		System.out.println("0. Salir.");
		System.out.println();
		
	}
	
	public static void mensajeAdd() {
		System.out.println("Ha seleccionado la opcion -AÑADIR-.");
		System.out.println("A que tabla quiere añadirle un registro?");
		System.out.println("1. Usuarios.");
		System.out.println("2. Posts.");
		System.out.println("3. Likes.");
	}
	public static void mensajeMostrar() {
		System.out.println("Ha seleccionado la opcion -MOSTRAR-.");
		System.out.println("Que tabla quiere visualizar?");
		System.out.println("1. Usuarios.");
		System.out.println("2. Posts.");
		System.out.println("3. Likes.");
	}
	
	public static int solicitud() {
		int opc;
		opc = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		return opc;
	}
}//Fin de la clase
