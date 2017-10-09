package com.example.demo.model.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.beans.Chamado;
import com.example.demo.model.beans.Sistema;
import com.example.demo.model.beans.SituacaoChamado;
import com.example.demo.model.repository.chamado.ChamadoRepositoryQuery;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>, ChamadoRepositoryQuery{

	public List<Chamado> findByDataAberturaBetween(LocalDate dataInicial, LocalDate dataFinal);
	
	public List<Chamado> findByNumeroOrderByNumero(Long numero);
	
	public List<Chamado> findBySistemaOrderByDataAbertura(Sistema sistema);
	
	public List<Chamado> findBySituacaoOrderByDataAbertura(SituacaoChamado situacao);
	
	public List<Chamado> findByDescricaoLike(String descricao);
}
