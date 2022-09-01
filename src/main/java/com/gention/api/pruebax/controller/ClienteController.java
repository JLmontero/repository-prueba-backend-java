package com.gention.api.pruebax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gention.api.pruebax.model.Cliente;
import com.gention.api.pruebax.model.Direccion;
import com.gention.api.pruebax.service.ClienteService;
import com.gention.api.pruebax.service.DireccionService;

@ResponseBody
@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	public ClienteService clienteService;

	@Autowired
	public DireccionService direccionService;

	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarCliente() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);

	}

	@GetMapping("/direcciones")
	public ResponseEntity<List<Direccion>> listarDireciones() {
		return new ResponseEntity<>(direccionService.findAll(), HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<Cliente> guardarUnCliente(@RequestBody Cliente unCliente) {
		return new ResponseEntity<>(clienteService.save(unCliente), HttpStatus.CREATED);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
		Cliente clienteEncontrado = clienteService.findBayId(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {
			clienteEncontrado.setNombre(cliente.getNombre());
			clienteEncontrado.setApellidos(cliente.getApellidos());
			clienteEncontrado.setEmail(cliente.getEmail());
			clienteEncontrado.setTelefono(cliente.getTelefono());
			return new ResponseEntity<>(clienteService.save(clienteEncontrado), HttpStatus.CREATED);

		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> eliminarUnCliente(@PathVariable Integer id) {
		clienteService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
