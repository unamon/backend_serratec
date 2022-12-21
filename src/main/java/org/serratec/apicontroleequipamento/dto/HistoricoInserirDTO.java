package org.serratec.apicontroleequipamento.dto;


public class HistoricoInserirDTO {
	private Long idMaterial;
	private Long idPessoaResponsavel;
	private Long status;
	private String observacoes;
	
	public HistoricoInserirDTO() {
		super();
	}
	
	
	public HistoricoInserirDTO(Long idMaterial, Long idPessoaResponsavel, Long status, String observacoes) {
        this.idMaterial = idMaterial;
        this.idPessoaResponsavel = idPessoaResponsavel;
        this.status = status;
        this.observacoes = observacoes;
    }


    public Long getIdMaterial() {
        return idMaterial;
    }


    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }


    public Long getIdPessoaResponsavel() {
        return idPessoaResponsavel;
    }


    public void setIdPessoaResponsavel(Long idPessoaResponsavel) {
        this.idPessoaResponsavel = idPessoaResponsavel;
    }


    public Long getStatus() {
        return status;
    }


    public void setStatus(Long status) {
        this.status = status;
    }


    public String getObservacoes() {
        return observacoes;
    }


    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

	
}
