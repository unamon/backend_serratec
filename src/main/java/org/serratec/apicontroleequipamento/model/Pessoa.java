package org.serratec.apicontroleequipamento.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.serratec.apicontroleequipamento.dto.PessoaInserirDTO;

import io.swagger.annotations.ApiModelProperty;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa",
discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("F")
@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@ApiModelProperty(value = "Id da pessoa")
	@Column(name = "id_int_pessoa")
	private Long id;
	
//	@ApiModelProperty(value = "Nome da empresa dona")
	@Column(name = "nome_txt_pessoa", nullable = false, length = 60)
	private String nome;

	//	@Email
	@Column(name = "email_txt_pessoa", nullable = false)
	private String email;
	
	@Column(name = "senha_txt_pessoa", nullable = false)
	private String senha;
	
	@Column(name = "tel_txt_pessoa", nullable = false, length = 11) 
	private String telefone;
	
//	@ApiModelProperty(value = "Endereco de pessoa")
	@OneToOne
	@JoinColumn(name = "id_int_end")
	private Endereco endereco;
	
//	@CPF(message = "CPF inválido!")
//	@ApiModelProperty(value = "CPF da pessoa")
	@Column(name="cpf_txt_pessoaF", nullable = false, length = 11)
	private String cpf;
	
//	@ApiModelProperty(value = "Perfil da pessoa")
	@ManyToOne
	@JoinColumn(name="id_int_perfil", referencedColumnName = "id_int_perfil")
	private Perfil perfil;
	
	public Pessoa(PessoaInserirDTO pessoaDTO, Endereco novoEndereco, Perfil perfil) {
		super();
		
		this.nome 		= pessoaDTO.getNome();
		this.email 		= pessoaDTO.getEmail();
		this.telefone 	= pessoaDTO.getTelefone();
		this.cpf 		= pessoaDTO.getCpf();
		this.endereco 	= novoEndereco;
        this.perfil     = perfil;
		
	}

	

/*     public Pessoa(PessoaInserirDTO pessoaDTO,Endereco novoEndereco) {
		super();
		
		this.nome 		= pessoaDTO.getNome();
		this.email 		= pessoaDTO.getEmail();
		this.senha 		= pessoaDTO.getTelefone();
		this.telefone 	= pessoaDTO.getTelefone();
		this.cpf 		= pessoaDTO.getCpf();
		this.endereco 	= novoEndereco;
    
		
	} */
	
	public Pessoa(String nome, String email, String senha, String telefone, Endereco endereco, String cpf,
            Perfil perfil) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.perfil = perfil;
    }



    public Pessoa() {
		super();
	}

	public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(Long id, String nome, @Email String email, String senha, String telefone,
			@NotBlank(message = "Preencha o endereço") Endereco endereco, @CNPJ(message = "CPF inválido!") String cpf, Perfil perfil) {
		super();
		this.id 		= id;
		this.nome	 	= nome;
		this.email 		= email;
		this.senha 		= senha;
		this.telefone 	= telefone;
		this.endereco 	= endereco;
		this.cpf 		= cpf;
		this.perfil 	= perfil;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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


	
}
