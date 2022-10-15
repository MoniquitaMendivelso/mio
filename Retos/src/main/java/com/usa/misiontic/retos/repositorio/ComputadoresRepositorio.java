package com.usa.misiontic.retos.repositorio;

import com.usa.misiontic.retos.entities.Computadores;
import com.usa.misiontic.retos.repositorio.crudRepositorio.ComputadoresCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ComputadoresRepositorio {

    @Autowired
    private ComputadoresCrudRepositorio ComputadoresCrudRepositorio;

    public List<Computadores>getAll(){
        return (List<Computadores>) ComputadoresCrudRepositorio.findAll();
    }

    public Optional<Computadores> getComputadores(int id){
        return ComputadoresCrudRepositorio.findById(id);
    }

    public Computadores save(Computadores p){
        return ComputadoresCrudRepositorio.save(p);
    }

    public void  delete(Computadores p){
        ComputadoresCrudRepositorio.delete(p);
    }
}
