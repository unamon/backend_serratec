package org.serratec.apicontroleequipamento.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Notificacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_int_notificacao")
    private Long id;
    @Column(name = "assunto_txt_notificacao")
    private String assunto;
    @Column(name = "mensagem_txt_notificacao", columnDefinition = "text")
    private String mensagem;
    @Column(name = "data_date_notificacao")
    private Instant data;
    @Column(name = "lida_bool_notificacao")
    private boolean lida;
    @ManyToOne
    @JoinColumn(name = "id_int_pessoa", referencedColumnName = "id_int_pessoa")
    private Pessoa pessoa;
    
    public Notificacao(Long id, Instant data, boolean lida, Pessoa pessoa) {
        this.id = id;
        this.data = data;
        this.lida = lida;
        this.pessoa = pessoa;
    }
    public Notificacao() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getData() {
        return data;
    }
    public void setData(Instant data) {
        this.data = data;
    }
    public boolean isLida() {
        return lida;
    }
    public void setLida(boolean lida) {
        this.lida = lida;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
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
    
}
