package com.example.demo.model.beans;

import java.util.HashMap;
import java.util.Map;

public enum Sistema {
	CONTA_CORRENTE("Conta Corente"),
	GRISCO("Gestão de Risco"),
	GESCOB("Gestão de Cobrança"),
	CADASTRO("Cadastro");
	
	private static Map<String,Sistema> map = new HashMap<String, Sistema>();
	
	static {
		map.put ("conta_correnta", Sistema.CONTA_CORRENTE);
		map.put ("grisco", Sistema.GRISCO);
		map.put ("gescob", Sistema.GESCOB);
		map.put ("cadastro", Sistema.CADASTRO);
	}
	
	private String descricao;

	private Sistema(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Sistema getSistema(String nome) {
		return map.get(nome);
	}
	
}
