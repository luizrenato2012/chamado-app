package com.example.demo.model.beans;

public enum TipoChamado {
	
	REQUISICAO("Requisição"),
	INCIDENTE("Incidente"),
	PROBLEMA("Problema"),
	TAREFA("Tarefa");
	
	private TipoChamado(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	

}
