package com.example.redeSocial.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.example.redeSocial.model.Postagem;

@Entity
@Table(name= "postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_postagem;
	
	@NotNull
	@Size(min=5, max=300)
	private String titulo; //pq char? Não seria String
	
	@NotNull
	@Size(min=5, max=10000)
	private String conteudo; 
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_publicacao = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull //precisa do @Size?
	private String imagem;
	
	private long saldo_reacoes;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")//pesquisar recursividade
	private Tema tema;

	public long getId_postagem() {
		return id_postagem;
	}

	public void setId_postagem(long id_postagem) {
		this.id_postagem = id_postagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getData_publicacao() {
		return data_publicacao;
	}

	public void setData_publicacao(Date data_publicacao) {
		this.data_publicacao = data_publicacao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public void addReacaoPositiva() {
		this.saldo_reacoes ++;
	}
	
	public void addReacaoNegativa() {
		this.saldo_reacoes --;
	}	
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public long getSaldo_reacoes() {
		return saldo_reacoes;
	}

	public void setSaldo_reacoes(long saldo_reacoes) {
	this.saldo_reacoes = saldo_reacoes;
		
	}	
}	



