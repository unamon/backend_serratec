package org.serratec.apicontroleequipamento.repository;

import java.util.Optional;

import org.serratec.apicontroleequipamento.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>{
	@Query("SELECT f FROM NotaFiscal f WHERE f.material.id = :id")
	public Optional<NotaFiscal> findByIdMaterial(Long id);
}
