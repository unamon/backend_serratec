package org.serratec.apicontroleequipamento.dto;

import org.serratec.apicontroleequipamento.model.Categoria;
import org.serratec.apicontroleequipamento.model.Origem;

public class MaterialRespostaDTO {
	private Long id;
	private String nome; 
	private Categoria categoria;
	private Origem origem;
	private String urlNotaFiscal;
	private String descricao;
	
	public MaterialRespostaDTO() {
		super();
	}

	public MaterialRespostaDTO(Long id, String nome, Categoria categoria, Origem origem, String urlNotaFiscal,
			String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.origem = origem;
		this.urlNotaFiscal = urlNotaFiscal;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public String getUrlNotaFiscal() {
		return urlNotaFiscal;
	}

	public void setUrlNotaFiscal(String urlNotaFiscal) {
		this.urlNotaFiscal = urlNotaFiscal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
