package org.serratec.apicontroleequipamento.dto;

import java.time.LocalDate;

import org.serratec.apicontroleequipamento.enums.OrigemENUM;


public class OrigemInserirDTO {
	private OrigemENUM tipoOrigem;
	private Long idPessoaOrigem;
	private LocalDate dataEnt;
	private LocalDate dataDevol;
	
	
	public OrigemInserirDTO() {
		super();
	}

	public OrigemInserirDTO(OrigemENUM tipoOrigem, Long idPessoaOrigem, LocalDate dataEnt, LocalDate dataDevol) {
		super();
		this.tipoOrigem = tipoOrigem;
		this.idPessoaOrigem = idPessoaOrigem;
		this.dataEnt = dataEnt;
		this.dataDevol = dataDevol;
	}
	public OrigemENUM getTipoOrigem() {
		return tipoOrigem;
	}
	public void setTipoOrigem(OrigemENUM tipoOrigem) {
		this.tipoOrigem = tipoOrigem;
	}
	public Long getIdPessoaOrigem() {
		return idPessoaOrigem;
	}
	public void setIdPessoaOrigem(Long PessoaOrigem) {
		this.idPessoaOrigem = PessoaOrigem;
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
