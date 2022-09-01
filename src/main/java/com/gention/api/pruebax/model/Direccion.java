package com.gention.api.pruebax.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

	@Id
	@Column(name = "id", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "uvicacion", length = 255, nullable = false)
	private String uvicacion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JsonIgnoreProperties("hibernateLazyInitializer, handler")
	@JoinColumn(name = "idCliente")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUvicacion() {
		return uvicacion;
	}

	public void setUvicacion(String uvicacion) {
		this.uvicacion = uvicacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private static final long serialVersionUID = 1L;

}
