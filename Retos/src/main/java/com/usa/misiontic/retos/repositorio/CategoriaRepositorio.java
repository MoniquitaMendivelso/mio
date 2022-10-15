package com.usa.misiontic.retos.repositorio;

import com.usa.misiontic.retos.entities.Categoria;
import com.usa.misiontic.retos.repositorio.crudRepositorio.CategoriaCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class CategoriaRepositorio {

    @Autowired
    private CategoriaCrudRepositorio CategoriaCrudRepositorio;

    public List<Categoria> getAll(){
        return (List<Categoria>) CategoriaCrudRepositorio.findAll();
    }

    public Optional<Categoria> getCategoria(int id){
        return CategoriaCrudRepositorio.findById(id);
    }

    public Categoria save(Categoria c){
        return CategoriaCrudRepositorio.save(c);
    }
    public void delete(Categoria c){
        CategoriaCrudRepositorio.delete(c);
    }
}
