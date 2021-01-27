package com.example.test.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Nombre")
public class Nombre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6965440490677211127L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idNombre")
	private int idNombre;
	
	@Column(name = "Nombre")
	private String Nombre;
	
	// Aqui se cambio el mappedBy = "nombre" porque si no manda error
	//https://stackoverflow.com/questions/4011472/mappedby-reference-an-unknown-target-entity-property
	
	@OneToMany(mappedBy = "idNombre", cascade = CascadeType.ALL)
	private List<Persona> Personas;

	/*public Nombre() {
		super();
	}*/

	public Nombre(int idNombre, String nombre, List<Persona> personas) {
		super();
		this.idNombre = idNombre;
		Nombre = nombre;
		Personas = personas;
	}

	public int getIdNombre() {
		return idNombre;
	}

	public void setIdNombre(int idNombre) {
		this.idNombre = idNombre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<Persona> getPersonas() {
		return Personas;
	}

	public void setPersonas(List<Persona> personas) {
		Personas = personas;
	}

	
}
