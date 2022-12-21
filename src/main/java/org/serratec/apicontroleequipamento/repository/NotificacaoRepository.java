package org.serratec.apicontroleequipamento.repository;

import org.serratec.apicontroleequipamento.model.Notificacao;
import org.serratec.apicontroleequipamento.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long>{
    Page <Notificacao> findByPessoa(Pessoa pessoa, Pageable pageable);
}
