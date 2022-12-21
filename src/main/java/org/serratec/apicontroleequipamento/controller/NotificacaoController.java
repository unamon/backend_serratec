package org.serratec.apicontroleequipamento.controller;

import org.serratec.apicontroleequipamento.dto.NotificacaoInserirDTO;
import org.serratec.apicontroleequipamento.model.Notificacao;
import org.serratec.apicontroleequipamento.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {
    
    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public Page<Notificacao> getAllNotificacao(@PageableDefault(
        page = 0,
        size = 10,
        sort = "data_date_notificacao",
        direction = Sort.Direction.ASC)
        Pageable pageable){
        return notificacaoService.getAllNotificacao(pageable);
    }

    @PostMapping
    public ResponseEntity<Notificacao> saveNotificacao(@RequestBody NotificacaoInserirDTO notificacaoDTO){
        return notificacaoService.saveNotificacao(notificacaoDTO);
    }
}
