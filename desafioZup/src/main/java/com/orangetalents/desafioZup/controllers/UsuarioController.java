package com.orangetalents.desafioZup.controllers;

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

import com.orangetalents.desafioZup.models.Endereco;
import com.orangetalents.desafioZup.models.Usuario;
import com.orangetalents.desafioZup.repository.UsuarioRepository;
import com.orangetalents.desafioZup.service.UsuarioService;

@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/endereco/novo/{id_Usuario}")
	public ResponseEntity<?> novoEndereco (@PathVariable(value = "id_Usuario") Long idUsuario, @Valid @RequestBody Endereco novoEndereco) {
			Endereco cadastro = usuarioService.cadastrarEndereco(novoEndereco, idUsuario);
			if(cadastro == null) {
				return new ResponseEntity<String>("Falha ao realizar o cadastro", HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<Endereco>(cadastro, HttpStatus.CREATED);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody @Valid Usuario usuario) {
		Usuario user = usuarioService.cadastrar(usuario);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById (@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping 
	public ResponseEntity<Usuario> put (@RequestBody Usuario usuario) {
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	@DeleteMapping("{id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}

}
