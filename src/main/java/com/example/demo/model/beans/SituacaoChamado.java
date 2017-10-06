package com.example.demo.model.beans;

import java.util.HashMap;
import java.util.Map;

public enum SituacaoChamado {

	ABERTO("Aberto"),
	AGUARDANDO("Aguardando"),
	EM_ATENDIMENTO ("Em Atendimento"),
	FECHADO("Fechado"),
	PENDENTE("Pendente");
	
	private static Map<String, SituacaoChamado> mapSituacao = new HashMap<String, SituacaoChamado>();
	
	static {
		mapSituacao.put("aberto", SituacaoChamado.ABERTO);
		mapSituacao.put("aguardando", SituacaoChamado.AGUARDANDO);
		mapSituacao.put("fechado", SituacaoChamado.FECHADO);
		mapSituacao.put("pendente", SituacaoChamado.PENDENTE);
	}
	
	private SituacaoChamado(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}

	public static SituacaoChamado getSituacao(String valor) {
		return mapSituacao.get(valor);
	}
	
}
