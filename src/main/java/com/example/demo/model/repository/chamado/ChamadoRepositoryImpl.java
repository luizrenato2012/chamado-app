package com.example.demo.model.repository.chamado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.StringUtils;

import com.example.demo.model.beans.Chamado;
import com.example.demo.model.beans.Sistema;
import com.example.demo.model.beans.SituacaoChamado;

public class ChamadoRepositoryImpl implements ChamadoRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Chamado> consultar(ChamadoFilter filtro) {
		StringBuilder strb = new StringBuilder();
		
		strb.append("from Chamado chamado left join fetch chamado.solicitante ")
			.append(" where ");
		
		if ( filtro.getSistema()!= null ) {
			strb.append("chamado.sistema = :sistema and ");
		}
		
		if ( filtro.getSituacao()!= null ) {
			strb.append("chamado.situacao = :situacao and ");
		}
		
		if ( filtro.getDataDe()!= null && filtro.getDataAte()!=null ) {
			strb.append("chamado.dataAbertura between :dataDe and :dataAte and ");
		}
		
		if ( !StringUtils.isEmpty(filtro.getDescricao()) ) {
			strb.append("chamado.descricao like :descricao and ");
		}
		
		if (filtro.getNumero()!= null && filtro.getNumero()!= 0l) {
			strb.append("chamado.numero =:numero");
		}
		
		String strHql = strb.toString();
		if ( strHql.endsWith("and ")) {
			strHql = strHql.substring(0, strHql.length() - 4);
		}
		
		Query query = this.entityManager.createQuery(strHql);
		
		if ( filtro.getSistema()!= null ) {
			query.setParameter("sistema", Sistema.getSistema(filtro.getSistema() ) ) ;
		}
		
		if ( filtro.getSituacao()!= null ) {
			query.setParameter("situacao", SituacaoChamado.getSituacao(filtro.getSituacao()));
		}
		
		if ( filtro.getDataDe()!= null && filtro.getDataAte()!=null ) {
			query.setParameter("dataDe", filtro.getDataDe());
			query.setParameter("dataAte", filtro.getDataAte());
		}
		
		if ( !StringUtils.isEmpty(filtro.getDescricao()) ) {
			query.setParameter("descricao", "%"+ filtro.getDescricao() +"%");
		}
		
		if (filtro.getNumero()!= null && filtro.getNumero()!= 0l) {
			query.setParameter("numero", filtro.getNumero());
		}
		
		return query.getResultList();
	}

}
