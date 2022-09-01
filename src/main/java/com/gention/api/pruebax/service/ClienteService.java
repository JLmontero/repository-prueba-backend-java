package com.gention.api.pruebax.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gention.api.pruebax.model.Cliente;

@Service
public interface ClienteService {
	
	public Cliente save(Cliente cliente);
	
	public Cliente findBayId(Integer id);
	
	public List<Cliente> findAll();
	
	public void delete(Integer id);

}
