package com.example.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Persona")
public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8084601291223908589L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idPersona")
	private int idPersona;
	
	@ManyToOne
	@JoinColumn(name = "idNombre")
	private Nombre idNombre;

	/*public Persona() {
		super();
	}*/

	public Persona(int idPersona, Nombre idNombre) {
		super();
		this.idPersona = idPersona;
		this.idNombre = idNombre;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public Nombre getIdNombre() {
		return idNombre;
	}

	public void setIdNombre(Nombre idNombre) {
		this.idNombre = idNombre;
	}
	
	
}
