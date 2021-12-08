package com.Farmacia.FarmaGen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Farmacia.FarmaGen.model.CategoriaModel;

/**
 * Interface responsável pela tabela Categoria, ela tem a finalidade de se
 * conectar e manipular o banco de dados.
 * 
 * @author Lucas Melo
 * @since 1.0
 *
 */

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	public List<CategoriaModel> findAllByTipoContainingIgnoreCase(String tipo);
}
