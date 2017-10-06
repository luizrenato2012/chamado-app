package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.beans.Usuario;
import com.example.demo.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario insert(Usuario usuario) {
		if (usuario.getId()!=null) {
			throw new ChamadoException("Erro ao incluir: Usuario ja cadastrado [id]="+ usuario.getId());
		}
		Usuario usuarioSalvo = this.repository.save(usuario);
		return usuarioSalvo;
	}
	
	public void update(Usuario usuario) {
		if (usuario.getId()==null) {
			throw new ChamadoException("Erro ao atualizar: Usuario não cadastrado.");
		}
		this.repository.save(usuario);
	}
	
	public Usuario load(Long id) {
		return this.repository.findOne(id);
	}
	
	public List<Usuario> listAll () {
		return this.repository.findAll();
	}
	
	public List<Usuario> listByNome(String nome) {
		return this.repository.findByNome(nome);
	}
	
	public void delete(Long id) {
		Usuario usuario = this.repository.findOne(id);
		
		if(usuario==null) {
			throw new ChamadoException("Erro ao excluir: usuario não cadastrado");
		}
		
		this.repository.delete(usuario);
	}
}
