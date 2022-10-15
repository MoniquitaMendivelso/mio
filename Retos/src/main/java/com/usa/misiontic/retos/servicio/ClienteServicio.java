package com.usa.misiontic.retos.servicio;

import com.usa.misiontic.retos.entities.Clientes;
import com.usa.misiontic.retos.entities.Computadores;
import com.usa.misiontic.retos.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Clientes> getAll(){
        return clienteRepositorio.getAll();
    }

    public Optional<Clientes> getClientes(int id){
        return clienteRepositorio.getClient(id);
    }

    public Clientes save(Clientes p){
        if(p.getIdClient()==null){
            return clienteRepositorio.save(p);
        }else{
            Optional<Clientes> e = clienteRepositorio.getClient(p.getIdClient());
            if (e.isPresent()){
                return p;
            }else{
                return clienteRepositorio.save(p);
            }
        }

    }

    public Clientes update(Clientes p){
        if(p.getIdClient()!=null){
            Optional<Clientes> q = clienteRepositorio.getClient(p.getIdClient());
            if(q.isPresent()){
                if(p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getAge()!=null){
                    q.get().setAge(p.getAge());
                }
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                clienteRepositorio.save(q.get());
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
        Optional<Clientes>p= clienteRepositorio.getClient(id);
        if(p.isPresent()){
            clienteRepositorio.delete(p.get());
            flag =true;
        }

        return flag;
    }
}
