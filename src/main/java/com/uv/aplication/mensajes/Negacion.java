package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Negacion extends Mensaje{
    private String[] bancoDeRespuestas = {"¿Estas seguro?", "¿Por que crees que no?", "¿Te lo has cuestionado?", "Siempre se puede cambiar de opinion"};
    private String[] bancoDePalabras = {"\\bno\\b", "\\bfalso\\b", "\\bnunca\\b", "\\bjamas\\b", "\\ben mi vida\\b", "\\bimposible\\b"};
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