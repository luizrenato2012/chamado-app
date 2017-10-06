package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.beans.Chamado;
import com.example.demo.model.beans.Sistema;
import com.example.demo.model.beans.SituacaoChamado;
import com.example.demo.model.beans.Usuario;
import com.example.demo.model.repository.ChamadoRepository;
import com.example.demo.model.repository.UsuarioRepository;
import com.example.demo.model.service.ChamadoException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Chamado inclui(Chamado chamado) {
		Usuario usuario = null;
		if (chamado.getSolicitante()!=null) {
			usuario = this.usuarioRepository.findOne(chamado.getSolicitante().getId());
			if (usuario==null) {
				throw new ChamadoException("Usuario invalido");
			}
			chamado.setSolicitante(usuario);
		}
		chamado.setSituacao(SituacaoChamado.ABERTO);
		return chamadoRepository.save(chamado);
	}

	public void atualiza(Chamado chamado) {
		this.chamadoRepository.save(chamado);
	}

	public Chamado busca(Long id) {
		return this.chamadoRepository.findOne(id);
	}

	public List<Chamado> listatodos() {
		return this.chamadoRepository.findAll();
	}

	public List<Chamado> buscaPor(String campo, String valor) {
		switch (campo) {
		case "numero" :
			return this.chamadoRepository.findByNumeroOrderByNumero(Long.parseLong(valor));
		case "descricao":
			return this.chamadoRepository.findByDescricaoLike(valor);
		case "sistema" :
			return buscaChamadoSistema(valor);
		case "situacao":
			return buscaChamadosSituacao(valor);
		default :
			throw new ChamadoException("Tipo de busca invalida");
		}
	}

	private List<Chamado> buscaChamadoSistema(String valor) {
		Sistema sistema = Sistema.getSistema(valor);
		if (sistema==null) {
			throw new ChamadoException("Sistema "+ valor + " invalido");
		}
		return this.chamadoRepository.findBySistemaOrderByDataAbertura(sistema);
	}

	private List<Chamado> buscaChamadosSituacao(String valor) {
		SituacaoChamado situacao = SituacaoChamado.getSituacao(valor);
		if (situacao==null) {
			throw new ChamadoException("Situacao "+ valor + "invalida");
		}
		return this.chamadoRepository.findBySituacaoOrderByDataAbertura(situacao);
	}

	public List<Chamado> buscaPorData(LocalDate dataInicial, LocalDate dataFinal) {
		return this.chamadoRepository.findByDataAberturaBetween(dataInicial, dataFinal);
	}


}
