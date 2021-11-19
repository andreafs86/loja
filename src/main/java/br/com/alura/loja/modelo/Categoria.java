package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@EmbeddedId
	private CategoriaId id = new CategoriaId();
	
	public Categoria() {
	}

	public CategoriaId getId() {
		return id;
	}

	public void setId(CategoriaId id) {
		this.id = id;
	}

	public Categoria(String nome) {
		super();
		this.id = new CategoriaId(nome, "xpto");
	}
	
	public String getNome() {
		return this.id.getNome();
	}
	
	public void setNome(String nome) {
		this.id.setNome(nome);
	}
	
}
