package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Hecho extends Mensaje {
    private String[] bancoDeRespuestas = {"¿Por que lo crees asi?", "¿Que te hace pensar asi?", "¿Lo es?", "¿Eso es lo que crees?", "Piensalo dos veces"};
    private String[] bancoDePalabras = {"\\bes\\b", "\\bson\\b", "\\bno soy\\b", "\\besta\\b", "\\beres\\b"};
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