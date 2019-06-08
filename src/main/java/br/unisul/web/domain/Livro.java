package br.unisul.web.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

	
@Entity
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double preco ;
	private String titulo;

	@JsonIgnore
	@OneToMany(mappedBy = "livro")
	private List<Autores> autores = new ArrayList<>();

	public Livro() {

	}

	public Livro(Double preco, String titulo) {
		this.preco = preco;
		this.titulo = titulo;
	}

	

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public void setAutores(List<Autores> autores) {
		this.autores = autores;
	}

	public List<Autores> getAutores() {
		return autores;
	}

	public void setCidades(List<Autores> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		//Categoria other = (Categoria) obj;
		if (preco == null) {
			//if (Other.getId != null)
				return false;
		} else if (!id.equals(getId()))
			return false;
		return true;
	}

}
