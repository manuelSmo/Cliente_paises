package com.example.cliente_paises.controller;

import com.example.cliente_paises.model.Pais;
import com.example.cliente_paises.service.PaisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaisesController {

    @Autowired
    PaisesService paisesService;

    @GetMapping(value = "paises", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> paises(){
        return paisesService.obtenerPaises();
    }

    @GetMapping(value = "paises/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pais> buscarPais(@PathVariable("name") String nombre){
        return paisesService.buscarPais(nombre);
    }
}
