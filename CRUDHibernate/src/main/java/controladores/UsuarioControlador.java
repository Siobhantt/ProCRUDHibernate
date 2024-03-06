package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import modelos.Usuario;
import proyecto.AppAdmin;

public class UsuarioControlador {
	public static String mod;
	public static int idUsuario=0;
	public static String Nombre;
	public static String Apellido;
	public static String Username;
	public static String Password;
	public static String Email;
	public static String campo;
	public static String opcion;
	// FUNCION DE CREAR USUARIO
	public static void crear() {
		System.out.println("Introduzca el nombre del usuario:");
		Nombre = AppAdmin.lee.nextLine();
		System.out.println("Introduzca el apellido del usuario:");
		Apellido = AppAdmin.lee.nextLine();
		System.out.println("Introduzca el username del usuario:");
		Username = AppAdmin.lee.nextLine();
		System.out.println("Introduzca el password del usuario:");
		Password = AppAdmin.lee.nextLine();
		System.out.println("Introduzca el email del usuario:");
		Email = AppAdmin.lee.nextLine();
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		try {

			Usuario usuario = new Usuario(idUsuario, Nombre, Apellido, Username, Password, Email);
			session.beginTransaction();

			session.save(usuario);
			session.getTransaction().commit();
			sessionFactory.close();

			System.out.println("Usuario creado con exito!" + "\n");
		} catch (Exception e) {
			System.out.println("Error al crear el usuario."+ "\n");
			e.printStackTrace();
		}
	}
	//borrar createUsuario

	// FUNCION DELETE
	public static void deleteUsuario() {
		System.out.println("Introduzca el id del Usuario a eliminar:");
		idUsuario = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, idUsuario);
			session.delete(usuario);
			session.getTransaction().commit();
			sessionFactory.close();
			System.out.println("Usuario eliminado"+ "\n");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el usuario"+ "\n");
		}
	
	}

//FUNCION UPDATE
	
	public static void updateU() {
		System.out.println("Introduzca el id del usuario a modificar:");
		idUsuario = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		System.out.println("Introduzca el campo a modificar: ");
		System.out.println("Si quiere modificar todos los campos teclee: todo");
		opcion = AppAdmin.lee.nextLine();
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			opcion.toLowerCase();
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, idUsuario);

			switch (opcion) {
			case "todo":
				System.out.println("Ha seleccionado -ACTUALIZAR TODO-");
				
				System.out.println("Introduzca la modificacion del nombre:");
				mod = AppAdmin.lee.nextLine();
				usuario.setNombre(mod);
				
				System.out.println("Introduzca la modificacion del apellido:");
				mod = AppAdmin.lee.nextLine();
				usuario.setApellidos(mod);
				
				System.out.println("Introduzca la modificacion del username:");
				mod = AppAdmin.lee.nextLine();
				usuario.setUsername(mod);
				
				System.out.println("Introduzca la modificacion del password:");
				mod = AppAdmin.lee.nextLine();
				usuario.setPassword(mod);
				
				System.out.println("Introduzca la modificacion del email:");
				mod = AppAdmin.lee.nextLine();
				usuario.setEmail(mod);
				break;
		
			case "nombre":
				System.out.println("Ha seleccionado -NOMBRE-");
				System.out.println("Introduzca la modificacion:");
				mod = AppAdmin.lee.nextLine();
				usuario.setNombre(mod);
				break;
				
			case "apellidos":
				System.out.println("Ha seleccionado -APELLIDO-");
				System.out.println("Introduzca la modificacion:");
				 mod = AppAdmin.lee.nextLine();
				 usuario.setApellidos(mod);
				break;
				
			case "username":
				System.out.println("Ha seleccionado -USERNAME-");
				System.out.println("Introduzca la modificacion:");
				 mod = AppAdmin.lee.nextLine();
				 usuario.setUsername(mod);
				break;
				
			case "password":
				System.out.println("Ha seleccionado -PASSWORD-");
			System.out.println("Introduzca la modificacion:");
			mod = AppAdmin.lee.nextLine();
			usuario.setPassword(mod);
				break;
				
			case "email":
				System.out.println("Ha seleccionado -EMAL-");
				System.out.println("Introduzca la modificacion:");
				mod = AppAdmin.lee.nextLine();
				usuario.setEmail(mod);
				break;
				
			default:
				System.out.println("El campo no existe.");
			}// fin del switch
			session.update(usuario);
			session.getTransaction().commit();
			sessionFactory.close();
			System.out.println("Usuario actualizado correctamente"+ "\n"); 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al actualizar el usuario."+ "\n");
		}
		// return opcion;
	}
	
	public static void mostrar() {
		int id;
		int opcI;
		System.out.println("Cuanta con dos opciones:");
		System.out.println("1)Mostrar un usuario.");
		System.out.println();
		System.out.println("2)Mostrar todos los usuarios.");
		opcI =AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		
		if(opcI == 1) {
			System.out.println("Introduzca el id del usuario que quiere visualizar:");
			id = AppAdmin.lee.nextInt();
			AppAdmin.lee.nextLine();
			UsuarioControlador.mostrarUsuario(id);
			//System.out.println(u);
		}else if (opcI==2) {
			UsuarioControlador.mostrarTodosUsuarios();
		}
	}

	//MOSTRAR UN USUARIO
	public static void mostrarUsuario(int idUsuario) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, idUsuario);
		
			System.out.println("ID: " + usuario.getIdUsuario());
		    System.out.println("Apellidos: " + usuario.getApellidos());
		    System.out.println("Nombre: " + usuario.getNombre());
		    System.out.println("Username: " + usuario.getUsername());
		    System.out.println("Email: " + usuario.getEmail());
		    System.out.println("Password: " + usuario.getPassword());
		    System.out.println();
		    
		    session.getTransaction().commit();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//fin de mostrar usuario
	
	//MOSTRAR TODOS LO USUARIOS
	public static void mostrarTodosUsuarios() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();
		
		String HQL = "FROM Usuario";
		try {
			session.beginTransaction();
			
			Query<Usuario> query = session.createQuery(HQL,Usuario.class);
			
			List<Usuario> lista = query.list();
			for (Usuario usuario : lista) {
			    System.out.println("ID: " + usuario.getIdUsuario());
			    System.out.println("Apellidos: " + usuario.getApellidos());
			    System.out.println("Nombre: " + usuario.getNombre());
			    System.out.println("Username: " + usuario.getUsername());
			    System.out.println("Email: " + usuario.getEmail());
			    System.out.println("Password: " + usuario.getPassword());
			    System.out.println();
			}
			session.getTransaction().commit();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//fin de mostrar usuario
	
}// Fin del UsuarioControlador