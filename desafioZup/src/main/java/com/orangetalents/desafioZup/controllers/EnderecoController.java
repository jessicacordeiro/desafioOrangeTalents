package com.orangetalents.desafioZup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.orangetalents.desafioZup.models.Endereco;
import com.orangetalents.desafioZup.repository.EnderecoRepository;

@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;
	
	@GetMapping 
	public ResponseEntity<List<Endereco>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}") 
	public ResponseEntity<Endereco> getById (@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping 
	public ResponseEntity<Endereco> put (@RequestBody Endereco endereco) {
		return ResponseEntity.ok(repository.save(endereco));
	}
	
	@DeleteMapping("{id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}

}
