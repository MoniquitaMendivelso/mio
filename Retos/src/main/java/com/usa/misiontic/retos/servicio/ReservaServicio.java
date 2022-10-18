package com.usa.misiontic.retos.servicio;

import com.usa.misiontic.retos.entities.Reserva;
import com.usa.misiontic.retos.repositorio.ContadorClientes;
import com.usa.misiontic.retos.repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public List<Reserva> getAll(){
        return reservaRepositorio.getAll();
    }

    public Optional<Reserva> getReserva(int id){
        return reservaRepositorio.getReserva(id);
    }

    public Reserva save(Reserva p){
        if(p.getIdReservation()==null){
            return reservaRepositorio.save(p);
        }else{
            Optional<Reserva> e = reservaRepositorio.getReserva(p.getIdReservation());
            if (e.isPresent()){
                return p;
            }else{
                return reservaRepositorio.save(p);
            }
        }

    }

    public Reserva update(Reserva p){
        if(p.getIdReservation()!=null){
            Optional<Reserva> q = reservaRepositorio.getReserva(p.getIdReservation());
            if(q.isPresent()){
                if(p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                if(p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if(p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
                }
                if(p.getScore()!=null){
                    q.get().setScore(p.getScore());
                }
                reservaRepositorio.save(q.get());
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
        Optional<Reserva>p= reservaRepositorio.getReserva(id);
        if(p.isPresent()){
            reservaRepositorio.delete(p.get());
            flag =true;
        }

        return flag;
    }



    public Status getReservationStatusReport(){
        List <Reserva> completed = reservaRepositorio.getReservationByStatus("completed");
        List <Reserva> cancelled = reservaRepositorio.getReservationByStatus("cancelled");
        return new Status (completed.size(), cancelled.size());
    }

    public List<Reserva> informePeriodoTiempoReservas(String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try {
            a = parser.parse(datoA);
            b = parser.parse(datoB);
        }catch(ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservaRepositorio.informePeriodoTiempoReservas(a, b);
        }else{
            return new ArrayList<>();
        }
    }

    /*
    public List<ContadorClientes> getTopClients(){
        return reservaRepositorio.getTopClient();
    }
*/
}
