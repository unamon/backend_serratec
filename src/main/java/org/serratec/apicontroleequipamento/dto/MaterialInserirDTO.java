package org.serratec.apicontroleequipamento.dto;

public class MaterialInserirDTO {

	private String nomeMaterial;
	private Long idCategoriaMaterial;
	private String descMaterial;
	private OrigemInserirDTO origem;
	private String numSerie;
	 
	public MaterialInserirDTO() {
		super();
	}

	public MaterialInserirDTO(String nomeMaterial, Long idCategoriaMaterial, String descMaterial,
			OrigemInserirDTO origem, String numSerie) {
		super();
		this.nomeMaterial = nomeMaterial;
		this.idCategoriaMaterial = idCategoriaMaterial;
		this.descMaterial = descMaterial;
		this.origem = origem;
		this.numSerie = numSerie;
	}

	public String getNomeMaterial() {
		return nomeMaterial;
	}

	public void setNomeMaterial(String nomeMaterial) {
		this.nomeMaterial = nomeMaterial;
	}

	public Long getIdCategoriaMaterial() {
		return idCategoriaMaterial;
	}

	public void setIdCategoriaMaterial(Long idCategoriaMaterial) {
		this.idCategoriaMaterial = idCategoriaMaterial;
	}

	public String getDescMaterial() {
		return descMaterial;
	}

	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}

	public OrigemInserirDTO getOrigem() {
		return origem;
	}

	public void setOrigem(OrigemInserirDTO origem) {
		this.origem = origem;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	

}
