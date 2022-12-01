package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Hecho extends Mensaje {
    private String[] bancoDeRespuestas = {"¿Por que lo crees asi?", "¿Que te hace pensar asi?", "¿Por que piensas eso?", "¿Eso es lo que crees?"};
    private String[] bancoDePalabras = {"\\bes\\b", "\\bson\\b", "\\bsoy\\b", "\\bno soy\\b"};
    private int respuesta;
   

    private int elegirRespuesta() {
        respuesta++;
        if(respuesta > bancoDeRespuestas.length - 1) {
            respuesta %= bancoDeRespuestas.length;
        }
        return respuesta;
    }

    public boolean verificarTipoDeMensaje(String entrada) {
        for (String palabra : bancoDePalabras) {
            Pattern patron = Pattern.compile(palabra, Pattern.CASE_INSENSITIVE);
            Matcher ocurrencia = patron.matcher(entrada);
          
            if(ocurrencia.find()) {
                return true;
            }    
        }

        return false;
    }

    public String generarRespuesta(String entrada) {
        if(!verificarTipoDeMensaje(entrada)) return siguienteMensaje.generarRespuesta(entrada);
        return  bancoDeRespuestas[elegirRespuesta()];
    }
}