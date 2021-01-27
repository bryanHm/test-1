package com.example.test.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.test.entity.Persona;
import com.example.test.repository.PersonaRep;
import com.example.test.service.PersonaServ;

@Service
public class PersonaServImpl implements PersonaServ{

	@Autowired
	private PersonaRep personaRep;
	
	@Override
	@Transactional
	public Iterable<Persona> findAll() {
		return personaRep.findAll();
	}

	@Override
	@Transactional
	public Page<Persona> findAll(Pageable pageable) {
		return personaRep.findAll(pageable);
	}

	@Override
	@Transactional
	public Optional<Persona> findById(Integer id) {
		return personaRep.findById(id);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaRep.save(persona);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		personaRep.deleteById(id);
	}
	

}
