package org.serratec.apicontroleequipamento.repository;

import java.util.List;

import org.serratec.apicontroleequipamento.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
	
	@Query("SELECT h FROM Historico h WHERE h.material.id = :id ORDER BY h.data DESC")
    List<Historico> getByIdMaterial(Long id);
	
	@Query("SELECT h FROM Historico h WHERE h.pessoa.id = :id")
	List<Historico> getByPessoa(Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM historico h WHERE h.id_int_material  = :id ORDER BY h.data_hist DESC LIMIT 1;")
	Historico getMaisRecente(Long id);
	
	@Query(nativeQuery = true, value = "select * "
			+ "from historico h "
			+ "where h.data_hist = (select max(h2.data_hist)"
			+ "					    from historico h2 "
			+ "                     where h2.id_int_material = h.id_int_material)"
			+ "order by id_int_hist desc")
	List<Historico> getHistoricosDistintosRecentes();
	
	@Query(nativeQuery = true, value = "select *"
			+ "from historico h "
			+ "where h.data_hist = (select max(h2.data_hist)"
			+ "					    from historico h2 "
			+ "                     where h2.id_int_material = h.id_int_material"
			+ "						and"
			+ "						h2.id_int_status = :id)"
			+ "order by id_int_hist desc")
	List<Historico> getHistoricoMaisRecentePorId(Long id);
}
