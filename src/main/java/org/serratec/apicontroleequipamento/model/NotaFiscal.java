package org.serratec.apicontroleequipamento.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class NotaFiscal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private Long id;

	@Lob
	private byte[] dados;

	@Column(name = "tipo_txt_foto")
	private String tipo;
	@Column(name = "nome_txt_foto")
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_int_pessoa")
	private Material material;
	
	public NotaFiscal(Long id, byte[] dados, String tipo, String nome, Material pessoa) {
		super();
		this.id = id;
		this.dados = dados;
		this.tipo = tipo;
		this.nome = nome;
		this.material = pessoa;
	}

	public NotaFiscal() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getDados() {
		return dados;
	}

	public void setDados(byte[] dados) {
		this.dados = dados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material pessoa) {
		this.material = pessoa;
	}

}
