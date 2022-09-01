package com.gention.api.pruebax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gention.api.pruebax.dao.ClienteDaoRepository;
import com.gention.api.pruebax.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	public ClienteDaoRepository clienteDaoRepository;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteDaoRepository.save(cliente);
	}

	@Override
	public Cliente findBayId(Integer id) {
		return clienteDaoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDaoRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		clienteDaoRepository.deleteById(id);
		
	}

}
