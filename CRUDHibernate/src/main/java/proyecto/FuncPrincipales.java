package proyecto;

import controladores.LikesControlador;
import controladores.PostsControlador;
import controladores.UsuarioControlador;

public class FuncPrincipales {

	public static void add() {
		int opcSwitch;
		// Añadir
		Utils.mensajeAdd();
		opcSwitch = Utils.solicitud();
		switch (opcSwitch) {
		case 1:
			// Añadir Usuario
			UsuarioControlador.crear();
			break;
		case 2:
			// Añadir Posts
			PostsControlador.crearPost();
			break;
		case 3:
			// Añadir Likes
			LikesControlador.darLike();
			break;
		default:
			System.out.println("Opcion no contemplada");
		}// FIN DEL SWITCH AÑADIR
	}

	public static void mostrar() {
		int opcSwitch;
		// Mostrar
		Utils.mensajeMostrar();
		opcSwitch = Utils.solicitud();
		switch (opcSwitch) {
		case 1:
			UsuarioControlador.mostrar();
			break;
		case 2:
			PostsControlador.mostrarPosts();
			break;
		case 3:
			LikesControlador.mostrarLikes();
			break;
		default:
			System.out.println("Opcion no contemplada.");
		}// Fin del switch MOSTRAR
	}

	public static void actualizar() {
		int opcSwitch;
		// Actualizar
		Utils.mensajeActualizar();
		opcSwitch = Utils.solicitud();
		switch (opcSwitch) {
		case 1:
			UsuarioControlador.updateU();
			break;
		case 2:
			PostsControlador.updatePost();
			break;
		default:
			System.out.println("Opcion no contemplada.");
		}// fin del switch ACTUALIZAR
	}

	public static void eliminar() {
		int opcSwitch;
		// Borrar
		Utils.mensajeBorrar();
		opcSwitch = Utils.solicitud();
		switch (opcSwitch) {
		case 1:
			UsuarioControlador.deleteUsuario();
			break;
		case 2:
			PostsControlador.borrarPosts();
			break;
		case 3:
			LikesControlador.borrarLike();
			break;
		default:
			System.out.println("Opcion no contemplada.");
		}// fin del switchBorrar
	}
}
