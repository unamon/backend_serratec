package org.serratec.apicontroleequipamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.serratec.apicontroleequipamento.dto.EnderecoInserirDTO;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "ID do endereco")
	@Column(name = "id_int_end")
	private Long id;

//	@NotBlank(message = "Preencha o CEP")
	@ApiModelProperty(value = "CEP do endereço")
	@Column(name = "end_txt_cep", nullable = false)
	private String cep;

//	@NotBlank(message = "Preencha a rua")
	@ApiModelProperty(value = "Rua do endereço")
	@Column(name = "end_txt_rua", length = 80, nullable = false)
	private String rua;

//	@NotBlank(message = "Preencha o bairro")
	@ApiModelProperty(value = "Bairro do endereço")
	@Column(name = "end_txt_bairro", length = 50, nullable = false)
	private String bairro;

//	@NotBlank(message = "Preencha a cidade")
	@ApiModelProperty(value = "Cidade do endereço")
	@Column(name = "end_txt_cidade", length = 80, nullable = false)
	private String cidade;

//	@NotBlank(message = "Preencha o numero")
	@ApiModelProperty(value = "Numero do endereço")
	@Column(name = "end_txt_nr", length = 20, nullable = false)
	private String numero;

	@ApiModelProperty(value = "Complemento do endereço")
	@Column(name = "end_txt_comp", length = 80, nullable = true)
	private String complemento;

//	@NotBlank(message = "Preencha a UF")
	@ApiModelProperty(value = "UF do endereço")
	@Column(name = "end_txt_uf", length = 2, nullable = false)
	private String uf;

	public Endereco(EnderecoInserirDTO enderecoDTO) {
		super();
		this.cep 			= enderecoDTO.getCep();
		this.rua 			= enderecoDTO.getRua();
		this.bairro		 	= enderecoDTO.getBairro();
		this.cidade 		= enderecoDTO.getCidade();
		this.numero 		= enderecoDTO.getNumero();
		this.complemento 	= enderecoDTO.getComplemento();
		this.uf 			= enderecoDTO.getUf();
	}

	public Endereco() {
		super();
	}

	public Endereco(Long id, String cep, String rua, String numero, String complemento, String bairro, String cidade,
			String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
