package br.unisul.clinica.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.unisul.clinica.domain.Paciente;

@Entity
public class PacienteDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sexo; // feminino ou masculino

	public PacienteDto() {
	}

	public PacienteDto(Integer id, String nome, String sexo) {
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
	}

	public PacienteDto(Paciente obj) {
		id = obj.getId();
		nome = obj.getNome();
		sexo = obj.getSexo();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
