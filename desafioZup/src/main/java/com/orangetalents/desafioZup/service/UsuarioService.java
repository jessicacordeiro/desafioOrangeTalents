package com.orangetalents.desafioZup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.desafioZup.models.Endereco;
import com.orangetalents.desafioZup.models.Usuario;
import com.orangetalents.desafioZup.repository.EnderecoRepository;
import com.orangetalents.desafioZup.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Usuario cadastrar(Usuario cadastro) {
		Optional<Usuario> cpfExistente = usuarioRepository.findByCpf(cadastro.getCpf());
		Optional<Usuario> emailExistente = usuarioRepository.findByEmail(cadastro.getEmail());
		
		if(cpfExistente.isPresent() || emailExistente.isPresent()) {
			return null;
		}
		
		return usuarioRepository.save(cadastro);
	}
	
	public Endereco cadastrarEndereco(Endereco novoEndereco, Long idUsuario) {
		Endereco enderecoExistente = enderecoRepository.save(novoEndereco);
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(idUsuario);
		
		if(usuarioExistente.isPresent()) {
			enderecoExistente.setUsuario(usuarioExistente.get());
			return enderecoRepository.save(enderecoExistente);
		}
		
		return null;
	}
}
