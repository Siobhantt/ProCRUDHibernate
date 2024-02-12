package proyecto.hibernate.CRUDHibernate;

import java.io.Serializable;
import java.util.Date;

public class Likes implements Serializable{
	public int idLikes;
	public int idUsuarios;
	public int idPosts;
	
	//Constructor vacio
	public Likes() {
		
	}

	public Likes(int idLikes, int idUsuarios, int idPosts) {
		super();
		this.idLikes = idLikes;
		this.idUsuarios = idUsuarios;
		this.idPosts = idPosts;
	}

	public int getIdLikes() {
		return idLikes;
	}

	public void setIdLikes(int idLikes) {
		this.idLikes = idLikes;
	}

	public int getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public int getIdPosts() {
		return idPosts;
	}

	public void setIdPosts(int idPosts) {
		this.idPosts = idPosts;
	}
	
}
