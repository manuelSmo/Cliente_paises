package com.example.cliente_paises.service;

import com.example.cliente_paises.model.Pais;

import java.util.List;

public interface PaisesService {

    List<Pais> obtenerPaises();
    List<Pais> buscarPais(String nombre);
}
