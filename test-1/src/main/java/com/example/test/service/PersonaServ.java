package com.example.test.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.test.entity.Persona;

public interface PersonaServ {
	public Iterable<Persona> findAll();
	
	public Page<Persona> findAll(Pageable pageable);
	
	public Optional<Persona> findById(Integer id);
	
	public Persona save(Persona persona);
	
	public void deleteById(Integer id);
}
