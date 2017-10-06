package com.example.demo.model.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="chamado", name="usuario")
@SequenceGenerator(name="SEQ_ID_USUARIO", sequenceName="chamado.seq_id_usuario", allocationSize=1)
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_USUARIO")
	private Long id;
	
	@NotNull
	@Size(min=3, max=30)
	private String nome;
	
	@Size(min=3,max=30)
	private String setor;
	
	@Size(min=2, max=15)
	private String ramal;

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

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	
}
