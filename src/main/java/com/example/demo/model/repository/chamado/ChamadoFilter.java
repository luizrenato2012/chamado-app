package com.example.demo.model.repository.chamado;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ChamadoFilter {
	
	private String situacao;
	
	private String sistema;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataDe;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataAte;
	
	private String descricao;


	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDate getDataDe() {
		return dataDe;
	}

	public void setDataDe(LocalDate dataDe) {
		this.dataDe = dataDe;
	}

	public LocalDate getDataAte() {
		return dataAte;
	}

	public void setDataAte(LocalDate dataAte) {
		this.dataAte = dataAte;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	
	
	

}
