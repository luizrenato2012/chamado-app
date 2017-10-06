package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.beans.Usuario;
import com.example.demo.model.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listaTodos() {
		List<Usuario> lista = this.usuarioService.listAll();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> listaPorNone(@PathVariable String nome) {
		List<Usuario> lista = this.usuarioService.listByNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> busca(@PathVariable("id") Long id) {
		Usuario usuario = this.usuarioService.load(id);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> inclui(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = this.usuarioService.insert(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void atualiza(@RequestBody Usuario usuario) {
		this.usuarioService.update(usuario);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void exclui(@PathVariable Long id) {
		this.usuarioService.delete(id);
	}
}
