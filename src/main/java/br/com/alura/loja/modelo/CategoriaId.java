package br.com.alura.loja.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8037910913771480970L;
	private String nome;
	private String tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public CategoriaId(String nome, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}

	public CategoriaId() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaId other = (CategoriaId) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(tipo, other.tipo);
	}

}
