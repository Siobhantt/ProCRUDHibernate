package controladores;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import modelos.Likes;
import modelos.Posts;
import modelos.Usuario;
import proyecto.AppAdmin;

public class LikesControlador {
	public static int idLikes;
	public static int idPosts;
	public static int idUsuario;
	
	public static void darLike() {
		System.out.println("Introduzca el idUsuario: ");
		idUsuario = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		System.out.println("A que post le quiere dar like?");
		idPosts = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Likes.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			if(obtenerPost(idPosts) && PostsControlador.obtenerUsuario(idUsuario)) {
				Likes like = new Likes(idLikes,idUsuario,idPosts);
				session.save(like);
				session.getTransaction().commit();
				sessionFactory.close();
				System.out.println("Se ha dado like al post: " +idPosts + "\n");
			}else {
				System.out.println("No existe el post.");
			}
		}catch (Exception e) {
			System.out.println("Error al dar like."+ "\n");
			e.printStackTrace();
		}
	}//Fin de dar like

	public static void mostrarLikes() {
		int idPosts;
	
		System.out.println("Introduzca el post del que quiere ver los likes:");
		System.out.println();
		idPosts =AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		String HQL = "FROM Likes WHERE idPosts = :idPosts";
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Likes.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			//Likes like = session.get(Likes.class, idPosts);
			Query <Likes> query = session.createQuery(HQL,Likes.class);
			query.setParameter("idPosts", idPosts);
			List <Likes> lista = query.list();
			for  (Likes like :lista) {
				System.out.println("IdPost: " + like.getIdPosts());
				System.out.println("IdUsuario: " + like.getIdUsuarios());
				System.out.println("idLike: " + like.getIdLikes());
				System.out.println();
			}
			session.getTransaction().commit();
			sessionFactory.close();
		}catch  (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean obtenerPost(int idPost) {
		String HQL = "FROM Posts WHERE idPosts = :idPosts";
		//Sesion usuario
		SessionFactory sessionFactoryU = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Posts.class).buildSessionFactory();
		Session sessionU = sessionFactoryU.openSession();
		sessionU.beginTransaction();
		Query<Posts> query = sessionU.createQuery(HQL,Posts.class);
		  query.setParameter("idPosts", idPost);
		    List<Posts> lista = query.list();
		    
		    sessionU.getTransaction().commit();
		    sessionU.close();
	
		    return !lista.isEmpty();//si ha encontrado un usuario(si la lista no esta vacia)
	}

	public static void borrarLike() {
		System.out.println("Introduzca el id del Like a eliminar:");
		idLikes = AppAdmin.lee.nextInt();
		AppAdmin.lee.nextLine();
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Likes.class).buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Likes like = session.get(Likes.class, idLikes);
			session.delete(like);
			session.getTransaction().commit();
			sessionFactory.close();
			System.out.println("Like eliminado"+ "\n");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar el Like"+ "\n");
		}
	}
}//fin del like controlador 
