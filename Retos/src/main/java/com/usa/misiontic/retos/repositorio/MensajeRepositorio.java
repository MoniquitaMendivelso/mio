package com.usa.misiontic.retos.repositorio;

import com.usa.misiontic.retos.entities.Mensaje;
import com.usa.misiontic.retos.repositorio.crudRepositorio.MensajeCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajeRepositorio {

    @Autowired
    private MensajeCrudRepositorio mensajeCrudRepositorio;

    public List<Mensaje>getAll(){
        return (List<Mensaje>) mensajeCrudRepositorio.findAll();
    }

    public Optional<Mensaje> getMensaje(int id){
        return mensajeCrudRepositorio.findById(id);
    }

    public Mensaje save(Mensaje p){
        return mensajeCrudRepositorio.save(p);
    }

    public void  delete(Mensaje p){
        mensajeCrudRepositorio.delete(p);
    }
}
