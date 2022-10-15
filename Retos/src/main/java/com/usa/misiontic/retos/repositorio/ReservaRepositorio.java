package com.usa.misiontic.retos.repositorio;

import com.usa.misiontic.retos.entities.Computadores;
import com.usa.misiontic.retos.entities.Reserva;
import com.usa.misiontic.retos.repositorio.crudRepositorio.ComputadoresCrudRepositorio;
import com.usa.misiontic.retos.repositorio.crudRepositorio.ReservaCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepositorio {

    @Autowired
    private ReservaCrudRepositorio reservaCrudRepositorio;

    public List<Reserva>getAll(){
        return (List<Reserva>) reservaCrudRepositorio.findAll();
    }

    public Optional<Reserva> getReserva(int id){
        return reservaCrudRepositorio.findById(id);
    }

    public Reserva save(Reserva p){
        return reservaCrudRepositorio.save(p);
    }

    public void  delete(Reserva p){
        reservaCrudRepositorio.delete(p);
    }
}
