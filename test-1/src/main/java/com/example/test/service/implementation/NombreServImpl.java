package com.example.test.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.test.entity.Nombre;
import com.example.test.repository.NombreRep;
import com.example.test.service.NombreServ;

@Service
public class NombreServImpl implements NombreServ{

	@Autowired
	private NombreRep nombreRep;
	
	@Override
	@Transactional
	public Iterable<Nombre> findAll() {
		return nombreRep.findAll();
	}

	@Override
	@Transactional
	public Page<Nombre> findAll(Pageable pageable) {
		return nombreRep.findAll(pageable);
	}

	// si fuese en el servicio integer en lugar de int, aqui
	// va a causar error.. lo mismo con persona
	@Override
	@Transactional
	public Optional<Nombre> findById(Integer id) {
		return nombreRep.findById(id);
	}

	@Override
	@Transactional
	public Nombre save(Nombre nombre) {
		return nombreRep.save(nombre);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		nombreRep.deleteById(id);
	}

}
