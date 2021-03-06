package com.example.demo.model.repository.chamado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.example.demo.model.beans.Chamado;
import com.example.demo.model.repository.ListaValorRepository;

public class ChamadoRepositoryImpl implements ChamadoRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ListaValorRepository listaValorRepository;
	
	@Override
	public List<Chamado> consultar(ChamadoFilter filtro) {
		Query query =null;
		StringBuilder strb = new StringBuilder();
		strb.append("from Chamado chamado left join fetch chamado.solicitante ");
		
		query = filtro.getTodos()? this.entityManager.createQuery(strb.toString()+ " order by chamado.dataAbertura " ) : 
								  this.criaQueryComParametros(filtro, strb);
		
		System.out.println(filtro);
		return query.getResultList();
	}

	private Query criaQueryComParametros(ChamadoFilter filtro, StringBuilder strb) {
		strb.append(" where ");
		this.criaConsulta(filtro, strb);
		
		String strHql = strb.toString();
		
		return preencheParametros(filtro, strHql);
	}

	private Query preencheParametros(ChamadoFilter filtro, String strHql) {
		Query query;
		if ( strHql.endsWith("and ")) {
			strHql = strHql.substring(0, strHql.length() - 4);
		}
		strHql = strHql.concat(" order by chamado.dataAbertura");
		query = this.entityManager.createQuery(strHql);
		
		if ( filtro.getSistema()!= null ) {
			query.setParameter("codigoSistema", filtro.getSistema()  ) ;
		}
		
		if ( filtro.getSituacao()!= null ) {
			query.setParameter("situacao", filtro.getSituacao()  );
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
		return query;
	}

	private void criaConsulta(ChamadoFilter filtro, StringBuilder strb) {
		if ( filtro.getSistema()!= null ) {
			strb.append("chamado.sistema.codigo = :codigoSistema and ");
		}
		
		if ( filtro.getSituacao()!= null ) {
			strb.append("chamado.situacao.codigo = :situacao and ");
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
	}

}
