package org.serratec.apicontroleequipamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.serratec.apicontroleequipamento.dto.CategoriaInserirDTO;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_int_categoria")
    private Long id;
    @NotNull
    @Column(name = "nome_txt_categoria",nullable = false)
    private String nome;
    @NotNull
    @Column(name = "desc_txt_categoria")
    private String descricao;
    
    public Categoria(CategoriaInserirDTO catDTO) {
		super();
		this.id = null;
		this.nome = catDTO.getNome();
		this.descricao = catDTO.getDescricao();
	}

	public Categoria() {
		super();
	}

	public Categoria(Long id, @NotNull String nome, @NotNull String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    } 


}
