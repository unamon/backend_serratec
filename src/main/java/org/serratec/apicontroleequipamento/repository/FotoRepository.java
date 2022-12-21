package org.serratec.apicontroleequipamento.repository;

import java.util.Optional;

import org.serratec.apicontroleequipamento.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FotoRepository extends JpaRepository<Foto, Long>{
	@Query("SELECT f FROM Foto f WHERE f.pessoa.id	 = :id")
	public Optional<Foto> findByIdPessoa(Long id);
	
}
