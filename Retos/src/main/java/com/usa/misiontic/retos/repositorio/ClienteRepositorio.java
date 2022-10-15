package com.usa.misiontic.retos.repositorio;


import com.usa.misiontic.retos.entities.Clientes;
import com.usa.misiontic.retos.repositorio.crudRepositorio.ClienteCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositorio {

    @Autowired
    private ClienteCrudRepositorio clienteCrudRepositorio;

    public List<Clientes>getAll(){
        return (List<Clientes>) clienteCrudRepositorio.findAll();
    }

    public Optional<Clientes> getClient(int id){
        return clienteCrudRepositorio.findById(id);
    }

    public Clientes save(Clientes p){
        return clienteCrudRepositorio.save(p);
    }

    public void  delete(Clientes p){
        clienteCrudRepositorio.delete(p);
    }
}
