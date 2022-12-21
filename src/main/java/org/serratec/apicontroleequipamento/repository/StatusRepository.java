package org.serratec.apicontroleequipamento.repository;


import java.util.Optional;

import org.serratec.apicontroleequipamento.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{
	@Query(nativeQuery = true, value = 
			"SELECT * FROM status s "
			+ "WHERE s.nome_txt_status = :nomeStatus"
			+ " AND s.boolativo = true")
	Optional<Status> findByNome(String nomeStatus);
}