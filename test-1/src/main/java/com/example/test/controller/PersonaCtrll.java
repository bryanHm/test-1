package com.example.test.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.test.entity.Persona;
import com.example.test.service.PersonaServ;

@RestController
@RequestMapping("/api/personas")
public class PersonaCtrll {
	@Autowired
	private PersonaServ personaServ;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Persona persona) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personaServ.save(persona));
	}
	
	// Read an persona
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Integer personaId) {
		Optional<Persona> opersona = personaServ.findById(personaId);
		
		if(!opersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(opersona);
	}
	
	// Update an persona
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Persona personaDetails, @PathVariable(value = "id") Integer personaId) {
		Optional<Persona> persona = personaServ.findById(personaId);
		
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		// BeanUtils.copyProperties(personaDetails, persona.get());
		persona.get().setIdNombre(personaDetails.getIdNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personaServ.save(persona.get()));
		
	}
	
	// Delete an persona
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Integer personaId) {
		
		if(!personaServ.findById(personaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		personaServ.deleteById(personaId);
		return ResponseEntity.ok().build();
	}
	
	// Read all personas
	@GetMapping
	public List<Persona> readAll () {
		
		List<Persona> personas = StreamSupport
				.stream(personaServ.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return personas;
	}
}
