package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.beans.Chamado;
import com.example.demo.model.beans.ListaValor;
import com.example.demo.model.repository.ListaValorRepository;
import com.example.demo.model.repository.chamado.ChamadoFilter;
import com.example.demo.service.ChamadoService;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {
	
	@Autowired
	private ChamadoService service;
	
	@Autowired
	private ListaValorRepository listaValorRepository;
	
	private Logger logger = Logger.getLogger(ChamadoController.class);
	
	@GetMapping("/teste")
	public String teste() {
		return "OK";
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Chamado> busca(@PathVariable("id")Long id) {
		Chamado chamado = this.service.busca(id);
		return new ResponseEntity<Chamado>(chamado,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Chamado>> pesquisa(ChamadoFilter filter) {
		this.logger.info("Pesquisando chamado");
		List<Chamado> chamados = this.service.buscaPorFiltro(filter);
		return new ResponseEntity<List<Chamado>>(chamados,HttpStatus.OK);
	}
	
	@GetMapping("/situacoes")
	public ResponseEntity<List<ListaValor>> buscaSituacoes() {
		this.logger.info("Listando situacoes");
		List<ListaValor> situacoes = this.listaValorRepository.findByTipoOrderByDescricao("SITUACAO_PROPOSTA");
		return new ResponseEntity<List<ListaValor>> (situacoes, HttpStatus.OK);
	}
	
	@GetMapping("/sistemas")
	public ResponseEntity<List<ListaValor>> buscaSistemas() {
		this.logger.info("Listando sistemas");
		List<ListaValor> sistemas = this.listaValorRepository.findByTipoOrderByDescricao("SISTEMA");
		return new ResponseEntity<List<ListaValor>> (sistemas, HttpStatus.OK);
	}
	
	@GetMapping("/tiposChamado")
	public ResponseEntity<List<ListaValor>> buscaTiposChamados() {
		this.logger.info("Listando tipo chamados");
		List<ListaValor> sistemas = this.listaValorRepository.findByTipoOrderByDescricao("TIPO_CHAMADO");
		return new ResponseEntity<List<ListaValor>> (sistemas, HttpStatus.OK);
	}
	
	@GetMapping("/listas")
	public ResponseEntity<Map<String,List<ListaValor>>> buscaListas() {
		this.logger.info("Listando lista de valores");
		Map<String,List<ListaValor>> map = new HashMap<String,List<ListaValor>>();
		map.put("situacoes", this.listaValorRepository.findByTipoOrderByDescricao("SITUACAO_CHAMADO"));
		map.put("sistemas",  this.listaValorRepository.findByTipoOrderByDescricao("SISTEMA"));
		map.put("tipos",  	 this.listaValorRepository.findByTipoOrderByDescricao("TIPO_CHAMADO"));
		return new ResponseEntity (map, HttpStatus.OK);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Chamado> inclui( @RequestBody @Valid Chamado chamado) {
		Chamado chamadoSalvo = this.service.inclui(chamado);
		return new ResponseEntity<Chamado>(chamadoSalvo, HttpStatus.CREATED);
	}
	
	@PutMapping
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	public void atualiza(@RequestBody  Chamado chamado) {
		this.service.atualiza(chamado);
	}
	

}
