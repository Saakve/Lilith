package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Presentacion extends Mensaje {
    private String[] bancoDeRespuestas = {"Y yo soy Lilith, un placer ", "Mucho gusto, yo  soy Lilith, ", "Es un lindo nombre. Yo soy Lilith"};
    private String[] bancoDePalabras = {"\\bme llamo\\b", "\\bme dicen\\b", "\\bmi nombre es\\b"};
    private int respuesta;
    private String nombre;

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
                nombre = entrada.substring(ocurrencia.end()).trim();
                return true;
            }    
        }

        return false;
    }

    public String generarRespuesta(String entrada) {
        if(!verificarTipoDeMensaje(entrada)) return siguienteMensaje.generarRespuesta(entrada);
        return  bancoDeRespuestas[elegirRespuesta()] + " " + nombre;
    }
}