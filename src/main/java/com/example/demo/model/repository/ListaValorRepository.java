package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.beans.ListaValor;

public interface ListaValorRepository extends JpaRepository<ListaValor, Long>{
	
	public List<ListaValor> findByTipoOrderByDescricao(String tipo); 
	
	public List<ListaValor> findByDescricaoLikeOrderByDescricao(String descricao); 
	
	public ListaValor findByCodigo (String codigo);

}
