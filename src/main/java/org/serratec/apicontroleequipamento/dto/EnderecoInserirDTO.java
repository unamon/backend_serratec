package org.serratec.apicontroleequipamento.dto;

public class EnderecoInserirDTO {
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;
	private String complemento;
	private String uf;
	public EnderecoInserirDTO(String cep, String rua, String bairro, String cidade, String numero, String complemento,
			String uf) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
	}
	public EnderecoInserirDTO() {
		super();
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
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

}
