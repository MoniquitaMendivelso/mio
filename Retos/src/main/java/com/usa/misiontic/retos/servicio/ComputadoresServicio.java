package com.usa.misiontic.retos.servicio;

import com.usa.misiontic.retos.entities.Computadores;
import com.usa.misiontic.retos.repositorio.ComputadoresRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputadoresServicio  {

    @Autowired
    private ComputadoresRepositorio ComputadoresRepositorio;

    public List<Computadores> getAll(){
        return ComputadoresRepositorio.getAll();
    }

    public Optional<Computadores> getComputadores(int id){
        return ComputadoresRepositorio.getComputadores(id);
    }

    public Computadores save(Computadores p){
        if(p.getId()==null){
            return ComputadoresRepositorio.save(p);
        }else{
            Optional<Computadores> e = ComputadoresRepositorio.getComputadores(p.getId());
            if (e.isPresent()){
                return p;
            }else{
                return ComputadoresRepositorio.save(p);
            }
        }

    }

    public Computadores update(Computadores p){
        if(p.getId()!=null){
            Optional<Computadores> q = ComputadoresRepositorio.getComputadores(p.getId());
            if(q.isPresent()){
                if(p.getBrand()!=null){
                    q.get().setBrand(p.getBrand());
                }
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getYear()!=null){
                    q.get().setYear(p.getYear());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                ComputadoresRepositorio.save(q.get());
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
        Optional<Computadores>p=ComputadoresRepositorio.getComputadores(id);
        if(p.isPresent()){
            ComputadoresRepositorio.delete(p.get());
            flag =true;
        }

        return flag;
    }
}
