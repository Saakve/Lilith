package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Gusto extends Mensaje{
    private String[] bancoDeRespuestas = {"¿Lo haces a menudo?", "¿Desde cuando te gusta?", "Eso es interesante", "¿Que mas te gusta?", "¿Que mas disfrutas?", "¿Por que te gusta?"};
    private String[] bancoDePalabras = {"\\bme gusta\\b", "\\bgusto\\b", "\\bgusta\\b", "\\bdisfruto\\b", "\\badoro\\b", "\\bme encanta\\b"};
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

            if(ocurrencia.find()) return true;
        }

        return false;
    }

    public String generarRespuesta(String entrada) {
        if(!verificarTipoDeMensaje(entrada)) return siguienteMensaje.generarRespuesta(entrada);
        return  bancoDeRespuestas[elegirRespuesta()];
    }
 
}