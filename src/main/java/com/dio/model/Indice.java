package com.dio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Indice {

	@Id
	private String nome;
	private Double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
