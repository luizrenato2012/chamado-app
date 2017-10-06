package com.example.demo.model.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="chamado", name="intervencao")
@SequenceGenerator(name="SEQ_ID_INTERVENCAO", sequenceName="chamado.seq_id_intervencao")
public class Intervencao {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_ID_INTERVENCAO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_chamado")
	private Chamado chamado;
	
	private LocalDateTime dataHora;
	
	@Lob
	private String descricao;
	
	@Lob
	private String observacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
