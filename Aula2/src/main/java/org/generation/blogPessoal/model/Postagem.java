package org.generation.blogPessoal.model;

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

/*Fazer anotações "@": parâmetros que colocamos nas classes e entidades que definem uma propriedade para elas.
(Fazem o entendimento de classe como entidade para serem interpretadas no banco de dados).*/
@Entity
@Table (name= "postagem")

public class Postagem {

	@Id //Id da postagem
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Comportamento ID: Esse atributo se transformará em uma chave primária
	private long id;
	
	@NotNull//notação: título não pode ser em branco
	@Size (min = 5, max=100) //Definição quantidade min e max de caracteres
	private String titulo;
	
	@NotNull//notação: título não pode ser em branco
	@Size (min = 5, max=100) //Definição quantidade min e max de caracteres
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date date = new java.sql.Date(System.currentTimeMillis()); //System.currentTimeMillis()vai capturar data, hora, seg e mil seg, que esse dado passou pela classe.*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}