package com.gention.api.pruebax.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gention.api.pruebax.model.Direccion;

@Repository
public interface DireccionDaoRepository extends CrudRepository<Direccion, Integer> {

}
