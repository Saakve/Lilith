package com.uv.aplication.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uv.aplication.analizadores.IAnalizador;

@CrossOrigin(origins = "https://salmon-beach-090d0c410.2.azurestaticapps.net")
@RestController
public class Router {

    @Autowired
    private IAnalizador analizador;

    @GetMapping("/")
    public Respuesta getRespuesta(@RequestParam(value = "mensaje", defaultValue = "Hola") String entrada) {
        return new Respuesta(analizador.generarRespuesta(entrada));
    }
}
