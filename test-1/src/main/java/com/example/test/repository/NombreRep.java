package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.entity.Nombre;

@Repository
public interface NombreRep extends JpaRepository<Nombre, Integer>{

}
