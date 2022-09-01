package com.gention.api.pruebax.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gention.api.pruebax.model.Direccion;

@Service
public interface DireccionService {
	
	public List<Direccion> findAll(); 

}
