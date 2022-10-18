package com.usa.misiontic.retos.controller;

import com.usa.misiontic.retos.repositorio.ContadorClientes;
import com.usa.misiontic.retos.entities.Reserva;
import com.usa.misiontic.retos.servicio.ReservaServicio;
import com.usa.misiontic.retos.servicio.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping("/all")
    public List<Reserva> getAll(){
        return reservaServicio.getAll();
    }

    @PostMapping( "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva p){
        return reservaServicio.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva p){
        return reservaServicio.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id){
        return reservaServicio.delete(Id);
    }
/*
    @GetMapping("/report-clients")
    public List<ContadorClientes> getReservationsReportClient(){
        return reservaServicio.getTopClients();
    }
*/
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reserva> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservaServicio.informePeriodoTiempoReservas(dateOne,dateTwo);
    }

    @GetMapping("/report-status")
    public Status getReservationsStatusReport(){
        return reservaServicio.getReservationStatusReport();
    }

}
