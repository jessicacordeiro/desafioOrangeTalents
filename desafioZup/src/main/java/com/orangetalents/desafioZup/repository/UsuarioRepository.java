package com.orangetalents.desafioZup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orangetalents.desafioZup.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> FindById(String id);
	Optional<Usuario> FindByCpf(String cpf);
	Optional<Usuario> FindByEmail(String email);
}
