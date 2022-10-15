package com.usa.misiontic.retos.repositorio.crudRepositorio;


import com.usa.misiontic.retos.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeCrudRepositorio extends CrudRepository<Mensaje, Integer> {
}
