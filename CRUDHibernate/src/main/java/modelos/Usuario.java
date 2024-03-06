package modelos;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	@Entity
	@Table(name = "Usuario")
	public class Usuario implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="idUsuarios")
		private int idUsuario;
		
		@Column(name="Nombre")
		private String Nombre;
		
		@Column(name="Apellidos")
		private String Apellidos;
		
		@Column(name="Username")
		private String Username;
		
		@Column(name="password")
		private String password;
		
		@Column(name="email")
		private String email;
		
		//Constructor vacio
		public Usuario() {
			
		}
		
		//Constructor con parametros
		
		public Usuario(int idUsuario,String Nombre, String Apellidos,String Username, String password, String email) {
			super();
			this.idUsuario = idUsuario;
			this.Nombre = Nombre;
			this.Apellidos = Apellidos;
			this.Username = Username;
			this.password = password;
			this.email = email;
		}
		
		//Getters y setters
		public int getIdUsuario() {
			return idUsuario;
		}
		
		public void setIdUsuario(int idUsuarios) {
			this.idUsuario = idUsuarios;
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
