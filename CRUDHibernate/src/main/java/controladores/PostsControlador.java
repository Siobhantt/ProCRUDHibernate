package controladores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import modelos.Posts;
import modelos.Usuario;
import proyecto.AppAdmin;
import proyecto.Utils;

public class PostsControlador {
	public static String mod;
	public static int idPosts;
	public static int idUsuario;
	public static String updated_at;
	public static String created_at;

	public static boolean obtenerUsuario(int idUsuario) {
		String HQL = "FROM Usuario WHERE idUsuario = :idUsuario";
		// Sesion usuario
		SessionFactory sessionFactoryU = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();
		Session sessionU = sessionFactoryU.openSession();
		sessionU.beginTransaction();
		Query<Usuario> query = sessionU.createQuery(HQL, Usuario.class);
		query.setParameter("idUsuario", idUsuario);
		List<Usuario> lista = query.list();

		sessionU.getTransaction().commit();
		sessionU.close();

		return !lista.isEmpty();// si ha encontrado un usuario(si la lista no esta vacia)
	}

	public static void crearPost() {
		System.out.println("Introduzca el id al que se asocia el post:");
		idUsuario = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		DateTimeFormatter formatof = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime ahora = LocalDateTime.now();
		updated_at = formatof.format(ahora);

		// Sesion post
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Posts.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			if (obtenerUsuario(idUsuario)) {
				Posts post = new Posts(idPosts, idUsuario, updated_at, updated_at);
				session.save(post);
				session.getTransaction().commit();
				sessionFactory.close();
				System.out.println("Post creado con exito!" + "\n");
			} else {
				System.out.println("No se ha podido crear el post porque el idUsuario no esta registrado.");
			}
			// Posts post = new Posts(idPosts,idUsuario,updated_at,updated_at);
		} catch (Exception e) {
			System.out.println("Error al crear el post." + "\n");
			e.printStackTrace();
		}
	}

	public static void updatePost() {
		// idusuario y fecha de actualizacion
		System.out.println("Introduzca el id del post a modificar:");
		idPosts = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();

		System.out.println("Introduzca el idUsuario a modificar:");
		idUsuario = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();

		DateTimeFormatter formatof = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime ahora = LocalDateTime.now();
		updated_at = formatof.format(ahora);

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Posts.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Posts post = session.get(Posts.class, idPosts);
			created_at = post.getUpdated_at();
			post.setCreated_at(created_at);
			post.setIdUsuarios(idUsuario);
			post.setUpdated_at(updated_at);

			session.update(post);
			session.getTransaction().commit();
			sessionFactory.close();
			System.out.println("Post actualizado correctamente" + "\n");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al actualizar el post." + "\n");
		}
	}

	public static void mostrarPosts() {
		int id;
		int opcI;
		System.out.println("Cuenta con dos opciones:");
		System.out.println("1)Mostrar un post.");
		System.out.println();
		System.out.println("2)Mostrar todos los posts.");
		opcI = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		String HQL = "From Posts";

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Posts.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			if (opcI == 1) {
				System.out.println("Introduzca el id del post que quiere visualizar:");
				id = AppAdmin.lee.nextInt();
				AppAdmin.lee.nextLine();
				Posts post = session.get(Posts.class, id);
				System.out.println("IdPost:" + post.getIdPosts());
				System.out.println("IdUsuario:" + post.getIdUsuarios());
				System.out.println("Created at:" + post.getCreated_at());
				System.out.println("Updated at:" + post.getUpdated_at());
				System.out.println();
			} else if (opcI == 2) {
				Query<Posts> query = session.createQuery(HQL, Posts.class);
				List<Posts> lista = query.list();
				for (Posts post : lista) {
					System.out.println("IdPost:" + post.getIdPosts());
					System.out.println("IdUsuario:" + post.getIdUsuarios());
					System.out.println("Created at:" + post.getCreated_at());
					System.out.println("Updated at:" + post.getUpdated_at());
					System.out.println();
				}
			} // fin del else
			session.getTransaction().commit();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// Fin de funcion mostrar

	public static void borrarPosts() {
		System.out.println("Introduzca el id del Post a eliminar:");
		idPosts = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Posts.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			Posts post = session.get(Posts.class, idPosts);
			session.delete(post);
			session.getTransaction().commit();
			sessionFactory.close();
			System.out.println("Post eliminado" + "\n");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el post" + "\n");
		}
	}

}// fin de posts controlador
