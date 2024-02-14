package proyecto.hibernate.CRUDHibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Posts")
public class Posts implements Serializable{
	
	@Id
	@Column(name = "idPosts")
	private int idPosts;
	
	@Column(name = "idUsuarios")
	private int idUsuarios;
	
	@Column(name = "created_at")
	private Date created_at;
	
	@Column(name = "updated_at")
	private Date updated_at;
	//Constructor vacio
	public Posts() {
		
	}
	public Posts(int idPosts, int idUsuarios, Date created_at, Date updated_at) {
		super();
		this.idPosts = idPosts;
		this.idUsuarios = idUsuarios;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public int getIdPosts() {
		return idPosts;
	}
	public void setIdPosts(int idPosts) {
		this.idPosts = idPosts;
	}
	public int getIdUsuarios() {
		return idUsuarios;
	}
	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
}
