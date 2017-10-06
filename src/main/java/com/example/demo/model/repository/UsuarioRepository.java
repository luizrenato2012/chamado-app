package com.example.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.beans.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.nome like %:nome%")
	public List<Usuario> findByNome(@Param("nome") String nome);

}
