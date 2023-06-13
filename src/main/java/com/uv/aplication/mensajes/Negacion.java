package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.Normalizer;

public class Negacion extends Mensaje{
    private String[] bancoDeRespuestas = {"¿Estas seguro?", "¿Por qué crees que no?", "¿Te lo has cuestionado?", "Siempre se puede cambiar de opinion", "Nada es imposible", "Todo puede cambiar"};
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
            Matcher ocurrencia = patron.matcher(eliminarAcentos(entrada));

            if(ocurrencia.find()) return true;
        }

        return false;
    }


    public String eliminarAcentos(String palabra) {
        palabra = Normalizer.normalize(palabra, Normalizer.Form.NFD);
        palabra = palabra.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return palabra;
    }

    public String generarRespuesta(String entrada) {
        if(!verificarTipoDeMensaje(entrada)) return siguienteMensaje.generarRespuesta(entrada);
        return  bancoDeRespuestas[elegirRespuesta()];
    }
 
}