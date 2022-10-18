package com.usa.misiontic.retos.controller;


import com.usa.misiontic.retos.entities.Clientes;
import com.usa.misiontic.retos.entities.Computadores;
import com.usa.misiontic.retos.servicio.ComputadoresServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*")
public class ComputadoresControlador {

    @Autowired
    private ComputadoresServicio ComputadoresServicio;

    @GetMapping("/all")
    public List<Computadores> getAll(){
        return ComputadoresServicio.getAll();
    }

    @PostMapping( "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computadores save(@RequestBody Computadores p){
        return ComputadoresServicio.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computadores update(@RequestBody Computadores p){
        return ComputadoresServicio.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id){
        return ComputadoresServicio.delete(Id);
    }
}
