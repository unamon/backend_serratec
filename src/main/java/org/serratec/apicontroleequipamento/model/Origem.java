package org.serratec.apicontroleequipamento.model;

import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.serratec.apicontroleequipamento.dto.OrigemInserirDTO;
import org.serratec.apicontroleequipamento.enums.OrigemENUM;


@Embeddable
public class Origem {
	@NotNull
	@Enumerated(EnumType.STRING)
	private OrigemENUM tipoOrigem;
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_int_pessoa")
	private Pessoa PessoaOrigem;
	@NotNull
	@Column(name = "dataEnt_dt_origem")
	private LocalDate dataEnt;
	@Column(name = "dataDevol_dt_origem")
	private LocalDate dataDevol;

	
	public Origem(OrigemInserirDTO origemDTO, Pessoa pessoaOrigem) {
		super();
		this.tipoOrigem = origemDTO.getTipoOrigem();
		this.dataEnt = origemDTO.getDataEnt();
		this.dataDevol = origemDTO.getDataDevol();
		this.PessoaOrigem = pessoaOrigem;
	}
	

	public Origem() {
		super();
	}

	public Origem(OrigemENUM tipoOrigem, Pessoa pessoa, LocalDate dataEnt, LocalDate dataDevol) {
		super();
		this.tipoOrigem = tipoOrigem;
		this.PessoaOrigem = pessoa;
		this.dataEnt = dataEnt;
		this.dataDevol = dataDevol;
	}

	public OrigemENUM getTipoOrigem() {
		return tipoOrigem;
	}

	public void setTipoOrigem(OrigemENUM tipoOrigem) {
		this.tipoOrigem = tipoOrigem;
	}

	public Pessoa getPessoaOrigem() {
		return PessoaOrigem;
	}

	public void setPessoaOrigem(Pessoa pessoaOrigem) {
		PessoaOrigem = pessoaOrigem;
	}

	public LocalDate getDataEnt() {
		return dataEnt;
	}

	public void setDataEnt(LocalDate dataEnt) {
		this.dataEnt = dataEnt;
	}

	public LocalDate getDataDevol() {
		return dataDevol;
	}

	public void setDataDevol(LocalDate dataDevol) {
		this.dataDevol = dataDevol;
	}

	

}
