package com.usa.misiontic.retos.servicio;

import com.usa.misiontic.retos.entities.Categoria;
import com.usa.misiontic.retos.entities.Computadores;
import com.usa.misiontic.retos.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> getAll(){
        return categoriaRepositorio.getAll();
    }

    public Optional<Categoria> getCategoria(int id){
        return categoriaRepositorio.getCategoria(id);
    }

    public Categoria save(Categoria p){
        if(p.getId()==null){
            return categoriaRepositorio.save(p);
        }else{
            Optional<Categoria> e = categoriaRepositorio.getCategoria(p.getId());
            if (e.isPresent()){
                return p;
            }else{
                return categoriaRepositorio.save(p);
            }
        }

    }

    public Categoria update(Categoria p){
        if(p.getId()!=null){
            Optional<Categoria> q = categoriaRepositorio.getCategoria(p.getId());
            if(q.isPresent()){

                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }

                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }

                categoriaRepositorio.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Categoria>p= categoriaRepositorio.getCategoria(id);
        if(p.isPresent()){
            categoriaRepositorio.delete(p.get());
            flag =true;
        }

        return flag;
    }
}
