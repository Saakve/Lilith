package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Emocion extends Mensaje {
    private String[] bancoDeRespuestas = {"¿Que te hace sentir asi?", "¿Por que te encuentras asi?", "¿Eso es lo que sientes?"};
    private String[] bancoDePalabras = {"\\bestoy\\b", "\\bme siento\\b", "\\bme encuentro\\b"};
    private int respuesta;
   

    private int elegirRespuesta() {
        respuesta++;
        if(respuesta > bancoDeRespuestas.length - 1) {
            respuesta %= bancoDeRespuestas.length;
        }
        return respuesta;
    }

    public boolean es(String entrada) {
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
        if(!es(entrada)) return siguienteMensaje.generarRespuesta(entrada);
        return  bancoDeRespuestas[elegirRespuesta()];
    }
}