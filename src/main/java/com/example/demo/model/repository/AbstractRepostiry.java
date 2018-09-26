package com.example.demo.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.example.demo.model.beans.BasicBean;
import com.tc.async.api.PostInit;

public abstract class AbstractRepostiry <T extends BasicBean>{
	
	protected List<T> lista;
	Map<Long,T> map;
	
	@PostConstruct
	protected void init() {
		this.lista = new ArrayList<>();
		this.map = new HashMap<>();
		
		this.preencheLista();
		this.preencheMap();
	}
	
	private void preencheMap() {
		this.lista.forEach( t -> this.map.put(t.getId(), t));
	}

	abstract protected void preencheLista() ;
	
	public T load(Long id) {
		return this.map.get(id);
	}
	
	public void save(T t) {
		t.setId(new Long(lista.size()));
		this.lista.add(t);
		this.map.put(t.getId(),t);
	}
	
	public List<T> listAll() {
		return this.lista;
	}
	
	public void remove (Long id) {
		this.lista.remove(id);
		this.map.remove(id);
	}
	
	public void update(T t) {
		T t2 = this.map.get(t.getId());
		if (t2==null) {
			throw new RuntimeException("Registro id "+ t.getId() + " nao encontrado");
		}
		t2 = t;
	}

}
