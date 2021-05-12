package com.orangetalents.desafioZup.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orangetalents.desafioZup.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findById(Long id);
}
