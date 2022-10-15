package com.usa.misiontic.retos.servicio;

import com.usa.misiontic.retos.entities.Computadores;
import com.usa.misiontic.retos.entities.Mensaje;
import com.usa.misiontic.retos.repositorio.ComputadoresRepositorio;
import com.usa.misiontic.retos.repositorio.MensajeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeServicio {

    @Autowired
    private MensajeRepositorio mensajeRepositorio;

    public List<Mensaje> getAll(){
        return mensajeRepositorio.getAll();
    }

    public Optional<Mensaje> getMensaje(int id){
        return mensajeRepositorio.getMensaje(id);
    }

    public Mensaje save(Mensaje p){
        if(p.getIdMessage()==null){
            return mensajeRepositorio.save(p);
        }else{
            Optional<Mensaje> e = mensajeRepositorio.getMensaje(p.getIdMessage());
            if (e.isPresent()){
                return p;
            }else{
                return mensajeRepositorio.save(p);
            }
        }

    }

    public Mensaje update(Mensaje p){
        if(p.getIdMessage()!=null){
            Optional<Mensaje> q = mensajeRepositorio.getMensaje(p.getIdMessage());
            if(q.isPresent()){
                if(p.getMessageText()!=null){
                    q.get().setMessageText(p.getMessageText());
                }

                mensajeRepositorio.save(q.get());
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
        Optional<Mensaje>p=mensajeRepositorio.getMensaje(id);
        if(p.isPresent()){
            mensajeRepositorio.delete(p.get());
            flag =true;
        }

        return flag;
    }
}
