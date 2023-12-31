package beans;

import java.util.Objects;

public class Usuario {
	
	private Long id;
	private String login;
	private String senha;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String fotoBase64;
	private String fotoMiniaturaBase64;
	private Long fotoBase64Size;
	private String curriculoBase64;
	private Long curriculoBase64Size;
	private Boolean temCurriculo;
	
	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}	

	public String getFotoBase64() {
		return fotoBase64;
	}

	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}
	
	public String getCurriculoBase64() {
		return curriculoBase64;
	}
	
	public void setCurriculoBase64(String curriculoBase64) {
		this.curriculoBase64 = curriculoBase64;
	}

	public Long getFotoBase64Size() {
		return fotoBase64Size;
	}

	public void setFotoBase64Size(Long fotoBase64Size) {
		this.fotoBase64Size = fotoBase64Size;
	}

	public Long getCurriculoBase64Size() {
		return curriculoBase64Size;
	}

	public void setCurriculoBase64Size(Long curriculoBase64Size) {
		this.curriculoBase64Size = curriculoBase64Size;
	}

	public String getFotoMiniaturaBase64() {
		return fotoMiniaturaBase64;
	}

	public void setFotoMiniaturaBase64(String fotoMiniaturaBase64) {
		this.fotoMiniaturaBase64 = fotoMiniaturaBase64;
	}

	public Boolean getTemCurriculo() {
		return temCurriculo;
	}

	public void setTemCurriculo(Boolean temCurriculo) {
		this.temCurriculo = temCurriculo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", email=" + email + ", telefone=" + telefone + ", logradouro=" + logradouro + ", numero="
				+ numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
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
