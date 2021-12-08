package com.Farmacia.FarmaGen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Farmacia.FarmaGen.model.CategoriaModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe responsável pela tabela produtos no banco de dados
 * 
 * @author AlanCS7
 * @since 1.0
 * 
 */

@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduto;

	private @NotBlank @Size(min = 1, max = 45) String nome;

	private @NotNull Boolean receita;

	private @NotNull Double preco;

	private @NotNull Boolean estoque;

	private @NotBlank @Size(min = 1, max = 45) String fabricante;

	private @ManyToOne @JoinColumn(name = "fk_categoria") @JsonIgnoreProperties("produtos") CategoriaModel categoria;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getReceita() {
		return receita;
	}

	public void setReceita(Boolean receita) {
		this.receita = receita;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Boolean getEstoque() {
		return estoque;
	}

	public void setEstoque(Boolean estoque) {
		this.estoque = estoque;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

}
