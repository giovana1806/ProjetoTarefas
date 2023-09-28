package com.projetojpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tarefas")
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	@Size(min = 8, message = "Minimo de 8 caracteres")
	private String  dataLimite;
	
	@NotNull
	@NotBlank
	private String detalhesTarefa;
	
	@NotNull
	@NotBlank
	private String statusTarefa;
	
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
	public String getDataLimite() {
		return dataLimite;
	}
	public void setDataLimte(String dataLimiteExecucao) {
		this.dataLimite = dataLimiteExecucao;
	}
	public String getDetalhesTarefa() {
		return detalhesTarefa; 
	}
	public void setDetalhesTarefa(String detalhesTarefa) {
		this.detalhesTarefa = detalhesTarefa;
	}
	public String getStatusTarefa() {
		return statusTarefa; 
	}
	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
}
