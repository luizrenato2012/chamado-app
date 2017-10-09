package com.example.demo.model.repository.chamado;

import java.util.List;

import com.example.demo.model.beans.Chamado;

public interface ChamadoRepositoryQuery {
	
	public List<Chamado> consultar (ChamadoFilter filtro);

}
