package com.gention.api.pruebax.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ResponseBody;

@Entity
@ResponseBody
@Table(name = "cliente")
public class Cliente implements Serializable {

	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	@Column(name = "apellidos", length = 60, nullable = false)
	private String apellidos;

	@Column(name = "telefono", length = 16, nullable = false)
	private String telefono;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private Set<Direccion> direciones = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Direccion> getDireciones() {
		return direciones;
	}

	public void setDireciones(Set<Direccion> direciones) {
		this.direciones = direciones;
		for (Direccion direccion : direciones) {
			direccion.setCliente(this);
		}
	}

	private static final long serialVersionUID = 1L;

}