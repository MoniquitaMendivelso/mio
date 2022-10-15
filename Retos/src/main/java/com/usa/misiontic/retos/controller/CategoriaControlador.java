package com.usa.misiontic.retos.controller;


import com.usa.misiontic.retos.entities.Categoria;
import com.usa.misiontic.retos.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio CategoriaServicio;

    @GetMapping("/all")
    public List<Categoria> getAll(){
        return CategoriaServicio.getAll();
    }

    @PostMapping( "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria p){
        return CategoriaServicio.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria update(@RequestBody Categoria p){
        return CategoriaServicio.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int Id){
        return CategoriaServicio.delete(Id);
    }

}
