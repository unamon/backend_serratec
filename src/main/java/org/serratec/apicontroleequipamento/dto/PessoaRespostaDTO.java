package org.serratec.apicontroleequipamento.dto;

import org.serratec.apicontroleequipamento.model.Endereco;
import org.serratec.apicontroleequipamento.model.Perfil;
import org.serratec.apicontroleequipamento.model.Pessoa;

public class PessoaRespostaDTO {
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Endereco endereco;
	private String cpf;
	private Perfil perfil;
	private String urlFoto;

	public PessoaRespostaDTO() {
		super();
	}
	public PessoaRespostaDTO(Pessoa pessoa, String uri) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefone = pessoa.getTelefone();
		this.endereco = pessoa.getEndereco();
		this.cpf = pessoa.getCpf();
		this.perfil = pessoa.getPerfil();
		this.urlFoto = uri;
	}

	public PessoaRespostaDTO(Long id, String nome, String email, String telefone, Endereco endereco, String cpf,
			Perfil perfil, String urlFoto) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
		this.perfil = perfil;
		this.urlFoto = urlFoto;
	}

	public Long getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

}
