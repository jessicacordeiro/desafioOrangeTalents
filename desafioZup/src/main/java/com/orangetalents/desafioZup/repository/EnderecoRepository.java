package com.orangetalents.desafioZup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orangetalents.desafioZup.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}
