package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.model.repository.chamado.ChamadoFilter;
import com.example.demo.service.ChamadoService;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {
	
	@Autowired
	private ChamadoService service;
	
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
