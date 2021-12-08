package com.Farmacia.FarmaGen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Farmacia.FarmaGen.model.CategoriaModel;
import com.Farmacia.FarmaGen.repository.CategoriaRepository;

/**
 * Classe responsável pelo CRUD
 * 
 * @author fabriciorocha
 * @since 1.0
 */
@RestController
@RequestMapping("/farmaGen/categorias")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> findAllCategoria() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> findByIdCategoria(@PathVariable(value = "id") long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado"));
	}

	@GetMapping("/nome/{tipo}")
	public ResponseEntity<List<CategoriaModel>> findByDescricaoCategoria(
			@PathVariable(value = "tipo") String tipo) {
		return ResponseEntity.ok(repository.findAllByTipoContainingIgnoreCase(tipo));
	}

	@PostMapping("/save")
	public ResponseEntity<CategoriaModel> post(@Valid @RequestBody CategoriaModel categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}

	@PutMapping("/update")
	public ResponseEntity<CategoriaModel> put(@Valid @RequestBody CategoriaModel categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		repository.deleteById(id);
	}
}
