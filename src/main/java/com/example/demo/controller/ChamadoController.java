package com.example.demo.controller;

import java.time.LocalDate;
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
	
	@GetMapping("/situacao/{situacao}")
	public ResponseEntity<List<Chamado>> buscaPorSituacao(@PathVariable("situacao") String situacao) {
		this.logger.info(String.format("situacao- %s", situacao));
		return buscaPor("situacao", situacao);
	}
	@GetMapping("/sistema/{sistema}")
	public ResponseEntity<List<Chamado>> buscaPorSistema(@PathVariable("sistema") String sistema) {
		this.logger.info(String.format("sistema- %s", sistema));
		return buscaPor("sistema", sistema);
	}

	private ResponseEntity<List<Chamado>> buscaPor(String campo,String valor) {
		return new ResponseEntity<List<Chamado>> (this.service.buscaPor(campo, valor), HttpStatus.OK);
	}
	
	@GetMapping("/dataAbertura?data-inicial={dataInicial}&data-final={dataFinal}")
	public ResponseEntity<List<Chamado>> buscaPorData(@PathVariable("data-inicial")LocalDate dataInicial, @PathVariable("data-final")LocalDate dataFinal) {
		this.logger.info(String.format("Data inicial %s- data final %s", dataInicial, dataFinal));
		return new ResponseEntity<List<Chamado>>( this.service.buscaPorData(dataInicial, dataFinal), HttpStatus.OK );
	}
	
	@GetMapping
	public ResponseEntity<List<Chamado>> listaTodos() {
		this.logger.info("Listando todos");
		List<Chamado> chamados = this.service.listatodos();
		return new ResponseEntity<List<Chamado>>(chamados,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Chamado> busca(@PathVariable("id")Long id) {
		Chamado chamado = this.service.busca(id);
		return new ResponseEntity<Chamado>(chamado,HttpStatus.OK);
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
