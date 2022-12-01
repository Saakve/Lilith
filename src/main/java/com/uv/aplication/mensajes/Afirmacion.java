package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Afirmacion extends Mensaje{
    private String[] bancoDeRespuestas = {"¿Lo has pensado dos veces", "Me parece que estas muy seguro", "¿Que te hace estar tan seguro?", "¿Siempre has sido tan seguro", "Tu seguridad es impresionante"};
    private String[] bancoDePalabras = {"\\bsi\\b", "\\bexactamente\\b", "\\bexacto\\b", "\\bclaro\\b", "\\btotalmente\\b", "\\bcreo\\b"};
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