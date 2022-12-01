package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Saludo extends Mensaje {
    private String[] bancoDeRespuestas = {"Hola soy lilith", "Saludos humano", "Hola que tal", "Hola", "Un gusto verte"};
    private String[] bancoDePalabras = {"\\bhola\\b", "\\bsaludos\\b", "\\bhey\\b","\\bque tal\\b", "\\bbuenos dias\\b"};
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
        return  bancoDeRespuestas[elegirRespuesta()] + ", ¿Como estas?";
    }
}
