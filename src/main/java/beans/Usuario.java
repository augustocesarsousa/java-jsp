package beans;

import java.util.Objects;

public class Usuario {
	
	private Integer id;
	private String login;
	private String senha;
	
	public Usuario() {
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}	

	public Usuario(Integer id, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public boolean acesso(String login, String senha) {
		if(login.equalsIgnoreCase("augusto") && senha.equals("123")) {
			return true;
		}
		
		return false;
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}	
	
}
