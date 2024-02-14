package proyecto.hibernate.CRUDHibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Likes")
public class Likes implements Serializable{
	
	@Id
	@Column(name ="idLikes")
	public int idLikes;
	
	@Column(name ="idUsuarios")
	public int idUsuarios;
	
	@Column(name ="idPosts")
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
