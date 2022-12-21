package org.serratec.apicontroleequipamento.dto;

import java.time.Instant;
import java.util.Set;

import org.serratec.apicontroleequipamento.model.Pessoa;
public class NotificacaoInserirDTO {
    
    private String assunto;
    private String mensagem;
    private Instant data;
    private Set<Pessoa> pessoas;
  
    public String getAssunto() {
        return assunto;
    }
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public Instant getData() {
        return data;
    }
    public void setData(Instant data) {
        this.data = data;
    }
    public Set<Pessoa> getPessoas() {
        return pessoas;
    }
    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
