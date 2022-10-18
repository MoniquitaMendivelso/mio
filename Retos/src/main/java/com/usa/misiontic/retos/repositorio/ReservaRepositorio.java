package com.usa.misiontic.retos.repositorio;

import com.usa.misiontic.retos.entities.Clientes;
import com.usa.misiontic.retos.entities.Reserva;
import com.usa.misiontic.retos.repositorio.crudRepositorio.ComputadoresCrudRepositorio;
import com.usa.misiontic.retos.repositorio.crudRepositorio.ReservaCrudRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Reserva> getReservationByStatus (String status){
        return reservaCrudRepositorio.findAllByStatus(status);
    }

    public List<Reserva> informePeriodoTiempoReservas (Date a, Date b){
        return reservaCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    /*
    public List<ContadorClientes> getTopClient(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = reservaCrudRepositorio.countTotalReservationByClient();
        for(int i=0;i < report.size();i++){
            res.add(new ContadorClientes((Long)report.get(i)[1], (Clientes) report.get(i)[0]));
        }
        return res;
    }

     */
}
