package proyecto.hibernate.CRUDHibernate;

import java.io.Serializable;

public class Usuarios implements Serializable{

	private int idUsuarios;
	private String Nombre;
	private String Apellidos;
	private String Username;
	private String password;
	private String email;
	
	//Constructor vacio
	public Usuarios() {
		
	}
	
	//Constructor con parametros
	
	public Usuarios(int idUsuarios,String Nombre, String Apellidos,String Username, String password, String email) {
		super();
		this.idUsuarios = idUsuarios;
		this.Nombre = Nombre;
		this.Apellidos = Apellidos;
		this.Username = Username;
		this.password = password;
		this.email = email;
	}
	
	//Getters y setters
	public int getIdUsuario() {
		return idUsuarios;
	}
	
	public void setIdUsuario(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	}
