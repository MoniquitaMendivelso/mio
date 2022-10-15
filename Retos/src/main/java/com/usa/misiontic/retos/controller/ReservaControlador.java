package com.usa.misiontic.retos.controller;

import com.usa.misiontic.retos.entities.Clientes;
import com.usa.misiontic.retos.entities.Reserva;
import com.usa.misiontic.retos.servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
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
}
