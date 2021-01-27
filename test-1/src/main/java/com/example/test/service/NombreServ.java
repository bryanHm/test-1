package com.example.test.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.test.entity.Nombre;

public interface NombreServ {
	
	public Iterable<Nombre> findAll();
	
	public Page<Nombre> findAll(Pageable pageable);
	
	//Revisar que realmente sea int y no integer
	public Optional<Nombre> findById(Integer nombreId);
	
	public Nombre save(Nombre nombre);
	
	public void deleteById(Integer id);
	
}
