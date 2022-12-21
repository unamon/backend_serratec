package org.serratec.apicontroleequipamento.dto;

import org.serratec.apicontroleequipamento.enums.TipoPessoaENUM;
import org.serratec.apicontroleequipamento.model.Endereco;


public class PessoaInserirDTO{
	private TipoPessoaENUM tipoPessoa;
	private String nome;
	private String cpf;
	private String telefone;
	private String email; 
	private String senha;
	

	private String cargo;
	private String cnpj;
	private String nomeFantasia;
	private String razaoSocial;
	
	private Endereco endereco;
	private Long idPerfil;

    public PessoaInserirDTO() {
    }
    public PessoaInserirDTO(TipoPessoaENUM tipoPessoa, String nome, String cpf, String telefone, String email,
            String senha, String cargo, String cnpj, String nomeFantasia, String razaoSocial, Endereco endereco,
            Long idPerfil) {
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.idPerfil = idPerfil;
    }

    public TipoPessoaENUM getTipoPessoa() {
        return tipoPessoa;
    }
    public void setTipoPessoa(TipoPessoaENUM tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Long getIdPerfil() {
        return idPerfil;
    }
    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    
    
}