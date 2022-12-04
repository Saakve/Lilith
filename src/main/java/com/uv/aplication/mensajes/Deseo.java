package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Deseo extends Mensaje{
    private String[] bancoDeRespuestas = {"¿Que tanto lo deseas?", "¿Desde cuando lo quieres?", "¿Por que lo quieres?", "¿Que mas te gusta?", "¿Que mas disfrutas?", "Eres capaz de lograrlo"};
    private String[] bancoDePalabras = {"\\bme gustaria\\b", "\\bdesearia\\b", "\\bdeseo\\b", "\\bquisiera\\b", "\\bquiero\\b"};
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