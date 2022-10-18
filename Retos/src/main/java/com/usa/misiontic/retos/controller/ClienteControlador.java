package com.usa.misiontic.retos.controller;


import com.usa.misiontic.retos.entities.Categoria;
import com.usa.misiontic.retos.entities.Clientes;
import com.usa.misiontic.retos.servicio.ClienteServicio;
import com.usa.misiontic.retos.servicio.ComputadoresServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/all")
    public List<Clientes> getAll(){
        return clienteServicio.getAll();
    }

    @PostMapping( "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes save(@RequestBody Clientes p){
        return clienteServicio.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes update(@RequestBody Clientes p){
        return clienteServicio.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id){
        return clienteServicio.delete(Id);
    }
}

