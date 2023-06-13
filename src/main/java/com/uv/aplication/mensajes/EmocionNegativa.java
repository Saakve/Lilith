package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.Normalizer;

public class EmocionNegativa extends Mensaje {
    private String[] bancoDeRespuestas = {"¿Qué te hace sentir así?", "¿Por qué lo crees así?", "Cuéntame, me interesa ayudarte", "Es una lástima", "Podemos hablar de ello"};

    private String[] bancoDePalabras = {"\\bfatal\\b", "\\bterrible\\b", "\\btriste\\b", "\\bmal\\b", "\\bdeprimido\\b", "\\bansioso\\b","\\binquieto\\b", "\\bmolesto\\b", "\\btristeza\\b","\\bcansado\\b", "\\bagotado\\b", "\\bagobiado\\b"};
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
            if(ocurrencia.find()) {
                return true;
            }    
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
        return  bancoDeRespuestas[elegirRespuesta()] + ". Todo saldrá mejor, estoy aquí para escucharte";
    }
}