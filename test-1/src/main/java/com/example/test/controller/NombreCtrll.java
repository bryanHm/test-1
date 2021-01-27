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

import com.example.test.entity.Nombre;
import com.example.test.service.NombreServ;

@RestController
@RequestMapping("/api/nombres")
public class NombreCtrll {

	@Autowired
	private NombreServ nombreServ;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Nombre nombre) {
		return ResponseEntity.status(HttpStatus.CREATED).body(nombreServ.save(nombre));
	}
	
	// Read an nombre
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Integer nombreId) {
		Optional<Nombre> onombre = nombreServ.findById(nombreId);
		
		if(!onombre.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(onombre);
	}
	
	// Update an nombre
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Nombre nombreDetails, @PathVariable(value = "id") Integer nombreId) {
		Optional<Nombre> nombre = nombreServ.findById(nombreId);
		
		if(!nombre.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		// BeanUtils.copyProperties(nombreDetails, nombre.get());
		nombre.get().setNombre(nombreDetails.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(nombreServ.save(nombre.get()));
		
	}
	
	// Delete an nombre
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Integer nombreId) {
		
		if(!nombreServ.findById(nombreId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		nombreServ.deleteById(nombreId);
		return ResponseEntity.ok().build();
	}
	
	// Read all nombres
	@GetMapping
	public List<Nombre> readAll () {
		
		List<Nombre> nombres = StreamSupport
				.stream(nombreServ.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return nombres;
	}
}
