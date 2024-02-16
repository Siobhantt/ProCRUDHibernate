package proyecto.hibernate.CRUDHibernate;

import java.util.Scanner;

public class AppAdmin {
	
	public static Scanner lee = new Scanner(System.in);
 
	public static void main(String[] args) {
    int opcPrincipal = 0;
    int opcSwitch = 0;
	
	AccesoBD a = new AccesoBD();
	FuncUsuarios f = new FuncUsuarios();
	  
	
	Utils.mensajeInicial();
	opcPrincipal = Utils.solicitud();
	
	while (opcPrincipal!=0) {
		switch (opcPrincipal) {
		case 1:
			//Añadir
			Utils.mensajeAdd();
			opcSwitch = Utils.solicitud();
			switch(opcSwitch) {
			case 1:
				//Añadir Usuario
				int id=0;
				String nombre;
				String apellido;
				String username;
				String password;
				String email;
				
				System.out.println("Introduzca el nombre del usuario:");
				nombre = AppAdmin.lee.nextLine();
				System.out.println("Introduzca el apellido del usuario:");
				apellido = AppAdmin.lee.nextLine();
				System.out.println("Introduzca el username del usuario:");
				username = AppAdmin.lee.nextLine();
				System.out.println("Introduzca el password del usuario:");
				password = AppAdmin.lee.nextLine();
				System.out.println("Introduzca el email del usuario:");
				email = AppAdmin.lee.nextLine();
				
				Usuarios u = new Usuarios(id,nombre,apellido,username,password,email);
				
				try {
					a.abrir();
					a.guardar(u);
					a.cerrar();
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				break;
			case 2:
				//Añadir Posts
				
				break;
			case 3:
				//Añadir Likes
				break;
				
				default:
			}
			break;
		case 2:
			//Mostrar
			Utils.mensajeMostrar();
			opcSwitch = Utils.solicitud();
			switch(opcSwitch) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:
				break;
			}
			
			break;
		case 3:
			//Actualizar
			
			break;
		case 4:
			//Borrar
			
			break;
			
			default:
				System.out.println("La opcion introducida no está contemplada.");
		}//Fin del switch
		Utils.mensajeInicial();
		opcPrincipal = Utils.solicitud();
	}//Fin del while
	System.out.println("Cerrando programa...");
    
  }//

}
