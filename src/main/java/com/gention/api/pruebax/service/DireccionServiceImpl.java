package com.gention.api.pruebax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gention.api.pruebax.dao.DireccionDaoRepository;
import com.gention.api.pruebax.model.Direccion;

@Service
public class DireccionServiceImpl implements DireccionService{
	
	@Autowired
	public DireccionDaoRepository direccionDaoRepository;

	@Override
	public List<Direccion> findAll() {
		return (List<Direccion>) direccionDaoRepository.findAll();
	}

}
