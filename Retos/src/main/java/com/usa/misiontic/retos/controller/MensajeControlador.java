package com.usa.misiontic.retos.controller;

import com.usa.misiontic.retos.entities.Clientes;
import com.usa.misiontic.retos.entities.Mensaje;
import com.usa.misiontic.retos.servicio.MensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MensajeControlador {

    @Autowired
    private MensajeServicio mensajeServicio;

    @GetMapping("/all")
    public List<Mensaje> getAll(){
        return mensajeServicio.getAll();
    }

    @PostMapping( "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje p){
        return mensajeServicio.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje p){
        return mensajeServicio.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id){
        return mensajeServicio.delete(Id);
    }

}

