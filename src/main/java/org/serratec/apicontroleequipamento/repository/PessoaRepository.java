package org.serratec.apicontroleequipamento.repository;

import java.util.Optional;

import org.serratec.apicontroleequipamento.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	Optional<Pessoa> findByEmail(String email);
}
