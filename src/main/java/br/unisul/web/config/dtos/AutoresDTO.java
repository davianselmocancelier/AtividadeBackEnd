package br.unisul.web.config.dtos;

import java.io.Serializable;

import br.unisul.web.domain.Autores;

public class AutoresDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public AutoresDTO() {
	}

	public AutoresDTO(Autores obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}