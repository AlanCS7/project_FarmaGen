package com.Farmacia.FarmaGen.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.minhaLojaDeGames.PlayGen.model.ProdutoModel;

/**
*
* Classe responsável pela tabela categoria no banco de dados
* 
* @author Wesley Ninaja
* @since 1.0
* 
*/

@Entity
@Table (name= "tb_categoria")
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotBlank
	private String tipo;
	
	@NotBlank
	private String sessao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	private List<ProdutoModel> produtos = new ArrayList<>();
	
	
	//GETTERS E SETTERS

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSessao() {
		return sessao;
	}

	public void setSessao(String sessao) {
		this.sessao = sessao;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
	
}
