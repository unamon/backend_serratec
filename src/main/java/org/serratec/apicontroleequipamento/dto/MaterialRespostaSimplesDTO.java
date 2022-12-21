package org.serratec.apicontroleequipamento.dto;

import java.time.LocalDateTime;

import org.serratec.apicontroleequipamento.model.Categoria;
import org.serratec.apicontroleequipamento.model.Historico;

public class MaterialRespostaSimplesDTO {
	private String nome;
	private Long idMaterial;
	private Categoria categoria;
	private String status;
	private String descricao;
	private String dono;
	private String numSerie;
	private LocalDateTime ultimaAlteracao;

	public MaterialRespostaSimplesDTO(Historico historicoDB) {
		this.numSerie = historicoDB.getMaterial().getNumSerie();
		this.nome = historicoDB.getMaterial().getNome();
		this.idMaterial = historicoDB.getMaterial().getId();
		this.categoria = historicoDB.getMaterial().getCategoria();
		this.status = historicoDB.getStatus().getNome();
		this.descricao = historicoDB.getMaterial().getDescricao();
		this.dono = historicoDB.getMaterial().getOrigem().getPessoaOrigem().getNome();
		this.ultimaAlteracao = historicoDB.getData();
	}

	public MaterialRespostaSimplesDTO() {
		super();
	}
	
	public MaterialRespostaSimplesDTO(String nome, Long idMaterial, Categoria categoria, String status,
			String descricao, String dono, String numSerie, LocalDateTime  ultimaAlteracao) {
		super();
		this.nome = nome;
		this.idMaterial = idMaterial;
		this.categoria = categoria;
		this.status = status;
		this.descricao = descricao;
		this.dono = dono;
		this.numSerie = numSerie;
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public LocalDateTime getUltimaAlteracao() {
		return ultimaAlteracao;
	}

	public void setUltimaAlteracao(LocalDateTime ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}

	public Long getId() {
		return idMaterial;
	}

	public void setId(Long id) {
		this.idMaterial = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

}
