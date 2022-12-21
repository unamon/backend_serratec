package org.serratec.apicontroleequipamento.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.serratec.apicontroleequipamento.dto.PessoaInserirDTO;

@DiscriminatorValue("J")
@Entity
public class PessoaJuridica extends Pessoa{

	@Column(name="cargo_txt_pessoaJ", length = 40)
	private String cargo;
	
	@Column(name="nome_fant_txt_pessoaJ", length = 55) // tamanho maximo permito rf
	private String nomeFantasia;

	@Column(name="razao_social_txt_pessoaJ", length = 144) 
	private String razaoSocial;

	@Column(name="cnpj_txt_pessoaJ", length = 14)
	private String CNPJ;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(PessoaInserirDTO pessoaDTO, Endereco novoEndereco, Perfil perfil) {
		super(pessoaDTO, novoEndereco, perfil);
		this.cargo			= pessoaDTO.getCargo();
		this.nomeFantasia	= pessoaDTO.getNomeFantasia();
		this.razaoSocial	= pessoaDTO.getRazaoSocial();
		this.CNPJ 			= pessoaDTO.getCnpj();
	}
	public PessoaJuridica(String cargo, String nomeFantasia, String razaoSocial, String cNPJ) {
		super();
		this.cargo 			= cargo;
		this.nomeFantasia 	= nomeFantasia;
		this.razaoSocial 	= razaoSocial;
		CNPJ 				= cNPJ;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	
	
}
