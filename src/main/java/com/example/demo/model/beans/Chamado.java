package com.example.demo.model.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema="chamado", name="chamado")
@SequenceGenerator( name="SEQ_ID_CHAMADO", sequenceName="chamado.seq_id_chamado",allocationSize=1 )
public class Chamado implements Serializable {
	
	private static final long serialVersionUID = 5517439158362631060L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_CHAMADO")
	private Long id;
	
	private Long numero;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private ListaValor tipo;
	
	private String assunto;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="data_abertura")
	private LocalDate dataAbertura;
	
	@Column(name="hora_abertura")
	private LocalTime HoraAbertura;
	
	@Column(name="data_fechamento")
	private LocalDate dataFechamento;
	
	@Column(name="hora_fechamento")
	private LocalTime horaFechamento;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_sistema")
	private ListaValor sistema;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_solicitante")
	private Usuario solicitante;
	
	@ManyToOne
	@JoinColumn(name="id_situacao")
	private ListaValor situacao;
	
	private String observacao;
	
	private String descricao;
	
	@OneToMany(mappedBy="chamado")
	private List<Intervencao> intervencoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public LocalTime getHoraAbertura() {
		return HoraAbertura;
	}

	public void setHoraAbertura(LocalTime horaAbertura) {
		HoraAbertura = horaAbertura;
	}


	public LocalTime getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(LocalTime horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Intervencao> getIntervencoes() {
		return intervencoes;
	}

	public void setIntervencoes(List<Intervencao> intervencoes) {
		this.intervencoes = intervencoes;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ListaValor getTipo() {
		return tipo;
	}

	public void setTipo(ListaValor tipo) {
		this.tipo = tipo;
	}

	public ListaValor getSistema() {
		return sistema;
	}

	public void setSistema(ListaValor sistema) {
		this.sistema = sistema;
	}

	public ListaValor getSituacao() {
		return situacao;
	}

	public void setSituacao(ListaValor situacao) {
		this.situacao = situacao;
	}
	
	

}
