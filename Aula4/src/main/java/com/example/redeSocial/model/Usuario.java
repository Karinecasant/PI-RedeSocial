package com.example.redeSocial.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "usuario") //usuário cadastro? Ou será separado?
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //vamos ter id_usuário? Ou é mesmo que "código"?
	private long id_usuario; //tem id usuário?
	
	@NotNull
	@Size(min=5, max=300) //deixo limitado e notnull?
	private String nome;
	
	@NotNull
	@Size(min=5, max=300) //deixo limitado e notnull?
	private long codigo; 
	
	private String url_foto; //foto perfil?
	
	@NotNull
	@Size(min=5, max=10000) //deixo limitado?
	private int codigo_usuario;
 	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_publicacao = new java.sql.Date(System.currentTimeMillis()); //não precisa pra gerar hitórico de logins

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public Date getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}
}	
	
	
	