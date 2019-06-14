package br.unisul.clinica.dto;

import java.io.Serializable;

import br.unisul.clinica.domain.Medicamento;

public class MedicamentoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String apresentacao;
	private double valor;

	public MedicamentoDto(Medicamento m) {
		id = m.getId();
		nome = m.getNome();
		apresentacao = m.getApresentacao();
		valor = m.getValor();
	}

	public MedicamentoDto() {
	}

	public MedicamentoDto(Integer id, String nome, String apresentacao, double valor) {
		this.id = id;
		this.nome = nome;
		this.apresentacao = apresentacao;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
