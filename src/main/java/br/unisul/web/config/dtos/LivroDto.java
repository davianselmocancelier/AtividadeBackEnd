package br.unisul.web.config.dtos;

import java.io.Serializable;
import java.util.List;

import br.unisul.web.domain.Autores;
import br.unisul.web.domain.Livro;

public class LivroDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Double preco;
	private String titulo;
	private List<Autores> autores;

	public LivroDto(Livro obj) {
		id = obj.getId();
		preco = obj.getPreco();
		titulo = obj.getTitulo();
		autores = obj.getAutores();
	}
	

	public List<Autores> getAutores() {
		return autores;
	}


	public void setAutores(List<Autores> autores) {
		this.autores = autores;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
