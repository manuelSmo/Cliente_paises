package com.example.cliente_paises.model;

import lombok.Data;

@Data
public class Pais {

    private String nombre;
    private String capital;
    private int poblacion;
    private String bandera;

    public Pais(String nombre, String capital, int poblacion, String bandera) {
        this.nombre = nombre;
        this.capital = capital;
        this.poblacion = poblacion;
        this.bandera = bandera;
    }
}
