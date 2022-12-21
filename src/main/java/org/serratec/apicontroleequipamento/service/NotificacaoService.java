package org.serratec.apicontroleequipamento.service;

import org.serratec.apicontroleequipamento.dto.NotificacaoInserirDTO;
import org.serratec.apicontroleequipamento.model.Notificacao;
import org.serratec.apicontroleequipamento.model.Pessoa;
import org.serratec.apicontroleequipamento.repository.NotificacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {
 
    @Autowired
    NotificacaoRepository repository;

    public Page<Notificacao> getAllNotificacao(Pageable pageable){
        Pessoa pessoa = null;
        Page<Notificacao> page = repository.findByPessoa(null, pageable);
        return page;
    }

    public ResponseEntity<Notificacao> saveNotificacao(NotificacaoInserirDTO notificacaoDTO){
        Notificacao notificacao = new Notificacao();
        BeanUtils.copyProperties(notificacaoDTO, notificacao);
        repository.save(notificacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacao);
    }
}
