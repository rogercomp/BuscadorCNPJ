package br.com.doc;

public class PessoaJuridica {

	private String atividadePrincipal;
	private String dataSitucao;
	private String nome;
	private String uf;
	private String telefone;
	private String atividadeSecundaria;
	private String situacao;
	private String bairro;
	private String municipio;
	private String logradouro;
	private String numero;
	private String cep;
	private String abertura;
	private String fantasia;
	private String cnpj;
	private String status;

	public String getStatus() {
		return "Status: " + status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDataSitucao() {
		return "Data Situação: " + dataSitucao;
	}

	public void setDataSitucao(String dataSitucao) {
		this.dataSitucao = dataSitucao;
	}

	public String getNome() {
		return "Nome: " + nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return "UF: " + uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return "Telefone: " + telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getAtividadeSecundaria() {
		return "Atividade(s) Secundária(s): " + atividadeSecundaria;
	}

	public void setAtividadeSecundaria(String atividadeSecundaria) {
		this.atividadeSecundaria = atividadeSecundaria;
	}

	public String getSituacao() {
		return "Situação: " + situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getBairro() {
		return "Bairro: " + bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return "Municipio: " + municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getLogradouro() {
		return "Logradouro: " + logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return "Número: " + numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return "CEP: " + cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getAbertura() {
		return "Data Abertura: " + abertura;
	}

	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}

	public String getFantasia() {
		return "Fantasia: " + fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCnpj() {
		return "CNPJ: " + cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAtividadePrincipal() {
		return "Atividade Principal: " + atividadePrincipal;
	}

	public void setAtividadePrincipal(String atividadePrincipal) {
		this.atividadePrincipal =  atividadePrincipal;
	}

}
