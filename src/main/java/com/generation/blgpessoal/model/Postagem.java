package com.generation.blgpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "tb_postagens") // create table tb_postagens(
public class Postagem {

	@Id // Primary Key (id)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;
	
	@NotBlank(message = "O atributo Título é obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 5, max = 100, message = "O atributo Título deve conter no minimo 05 e no máximo 100 caracteres!")
	private String titulo;
	
	@NotNull(message = "O atributo Texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo Texto deve conter no minimo 10 e no máximo 1000 caracteres!")
	private String texto;
	
	@UpdateTimestamp //@createTimestamp 
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema; // OBJETO TEMA PARA CRIAR A RELAÇÃO FK
	
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	
}
