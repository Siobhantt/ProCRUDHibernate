package proyecto.hibernate.CRUDHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


//Importante
/*El profesor se crea esta clase aparte
 * aqui guarda la session factory, la sesssion y transacciones*/
public class AccesoBD {
	/*Pedir a chat que me explique esto luego*/
	private SessionFactory sf;
	private Session sesion;
	private Transaction transaction;
	
	 public AccesoBD() {
	        config();
	    }
	
	protected void config() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		try {
			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	public void abrir() throws Exception{
		config();
		sesion = sf.openSession();
		transaction = sesion.beginTransaction();
	}
	public void cerrar(){
		try {
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		sf.close();
	}
	 public Object guardar(Object cosa) {
	        return sesion.save(cosa);
	    }
	 

	
}
