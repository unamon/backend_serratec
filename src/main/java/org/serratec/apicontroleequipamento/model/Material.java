package org.serratec.apicontroleequipamento.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.serratec.apicontroleequipamento.dto.MaterialInserirDTO;

@Entity
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_int_material")
	private Long id;

	@NotNull(message = "Preencha o nome")
	@Column(name = "nome_txt_material", nullable = false, length = 60)
	private String nome;

	@Column(name = "num_serie_txt_material")
	private String numSerie;

	@Column(name = "desc_txt_material", columnDefinition = "TEXT")
	private String descricao;

	@NotNull(message = "Preencha a categoria")
	@ManyToOne
	@JoinColumn(name = "id_int_categoria", referencedColumnName = "id_int_categoria")
	private Categoria categoria;

	@Embedded
	private Origem origem;

	public Material() {
		super();
	}

	public Material(MaterialInserirDTO materialDTO, Categoria cat, Origem origem) {
		super();
		this.descricao = materialDTO.getDescMaterial();
		this.nome = materialDTO.getNomeMaterial();
		this.numSerie = materialDTO.getNumSerie();
		this.categoria = cat;
		this.origem = origem;

	}

	public Material(Long id, @NotNull(message = "Preencha o nome") String nome, String numSerie, String descricao,
			@NotNull(message = "Preencha a categoria") Categoria categoria, Origem origem) {
		super();
		this.id = id;
		this.nome = nome;
		this.numSerie = numSerie;
		this.descricao = descricao;
		this.categoria = categoria;
		this.origem = origem;
	}

	public Long getId() {
		return id;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
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

}
