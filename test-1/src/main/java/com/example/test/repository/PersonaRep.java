package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.entity.Persona;

@Repository
public interface PersonaRep extends JpaRepository<Persona, Integer>{

}
