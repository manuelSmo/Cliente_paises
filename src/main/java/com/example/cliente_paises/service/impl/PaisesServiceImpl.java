package com.example.cliente_paises.service.impl;

import com.example.cliente_paises.model.Pais;
import com.example.cliente_paises.service.PaisesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisesServiceImpl implements PaisesService {

    private String url = "https://restcountries.com/v2/all";
    @Autowired
    RestTemplate restTemplate;

    //Se obtiene un objeto json y mapeamos solo los datos que necesitamos
    @Override
    public List<Pais> obtenerPaises() {
        var resultado = restTemplate.getForObject(url,String.class);
        var mapper = new ObjectMapper();
        var paises = new ArrayList<Pais>();
        ArrayNode arrayNode;
        try {
            arrayNode = (ArrayNode) mapper.readTree(resultado);
            for (Object object: arrayNode) {
                ObjectNode json = (ObjectNode) object;
                paises.add(new Pais(json.get("name").asText(),
                        (json.has("capital")?json.get("capital").asText():"No tiene"),
                        json.get("population").asInt(),
                        json.get("flag").asText()));
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return paises;
    }

    //filtramos por el nombre del pais que necesitamos
    @Override
    public List<Pais> buscarPais(String nombre) {
        return obtenerPaises().stream()
                .filter(pais -> pais.getNombre().contains(nombre))
                .collect(Collectors.toList());
    }
}
