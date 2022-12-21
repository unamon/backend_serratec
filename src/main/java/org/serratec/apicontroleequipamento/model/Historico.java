package org.serratec.apicontroleequipamento.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Historico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_int_hist")
	private Long id;
	@NotNull
	@ManyToOne //(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_int_material")
	private Material material;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_int_status")
	private Status status;
	//@NotNull
	@ManyToOne
	@JoinColumn(name = "id_int_pessoa", nullable = true)
	private Pessoa pessoa; // responsavel pelo material

	@Column(name = "data_hist")
	private LocalDateTime data = LocalDateTime.now(); // data automatica

	@Column(name = "obs_txt_hist", columnDefinition = "TEXT")
	private String observacao;

	
	public Historico() {
		super();
	}

    

	public Historico(@NotNull Material material, @NotNull Status status, Pessoa pessoa, String observacao) {
        this.material = material;
        this.status = status;
        this.pessoa = pessoa;
        this.observacao = observacao;
    }



    public Historico(Long id, @NotNull Material material, @NotNull Status status, @NotNull Pessoa pessoa, LocalDateTime data,
			String observacao) {
		super();
		this.id = id;
		this.material = material;
		this.status = status;
		this.pessoa = pessoa;
		this.data = data;
		this.observacao = observacao;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

	
}
