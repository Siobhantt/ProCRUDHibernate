package proyecto;

import java.util.Scanner;

public class AppAdmin {
	public static Scanner lee = new Scanner(System.in);

	public static void main(String[] args) {
		int opcPrincipal;
		int opcSwitch;
		// int opcI;
		Utils.mensajeInicial();
		opcPrincipal = Utils.solicitud();

		while (opcPrincipal != 0) {
			switch (opcPrincipal) {
			case 1:
				FuncPrincipales.add();
				break;
			case 2:
				FuncPrincipales.mostrar();
				break;
			case 3:
				FuncPrincipales.actualizar();
				break;
			case 4:
				FuncPrincipales.eliminar();
				break;
			default:
				System.out.println("Opcion introducida no está contemplada.");
			}// Fin del switchPrincipal
			Utils.mensajeInicial();
			opcPrincipal = Utils.solicitud();
		} // Fin del while
		System.out.println("Cerrando programa...");
	}//
}