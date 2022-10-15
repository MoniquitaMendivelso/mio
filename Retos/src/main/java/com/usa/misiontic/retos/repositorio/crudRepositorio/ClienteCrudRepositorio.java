package com.usa.misiontic.retos.repositorio.crudRepositorio;

import com.usa.misiontic.retos.entities.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepositorio extends CrudRepository<Clientes, Integer> {
}
