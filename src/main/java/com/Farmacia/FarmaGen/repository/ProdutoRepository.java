package com.Farmacia.FarmaGen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Farmacia.FarmaGen.model.ProdutoModel;

/**
 * 
 * Interface responsável por se conectar e manipular o banco de dados.
 * 
 * @author JosianeCaroliny
 * @since 1.0
 * 
 */

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);

}
