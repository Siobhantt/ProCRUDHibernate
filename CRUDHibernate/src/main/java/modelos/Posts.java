package modelos;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Posts")
public class Posts implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPosts")
	private int idPosts;
	
	@Column(name = "idUsuarios")
	private int idUsuarios;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "updated_at")
	private String updated_at;
	//Constructor vacio
	public Posts() {
		
	}
	public Posts(int idPosts, int idUsuarios, String  created_at,String updated_at) {
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
	public String  getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String  created_at) {
		this.created_at = created_at;
	}
	public String  getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String  updated_at) {
		this.updated_at = updated_at;
	}
	
}