package proyecto.hibernate.CRUDHibernate;

import java.io.Serializable;
import java.util.Date;

public class Posts implements Serializable{
	private int idPosts;
	private int idUsuarios;
	private Date created_at;
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
