package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmocionPositiva extends Mensaje {
    private String[] bancoDeRespuestas = {"Me encantar esuchar eso, ¿Por que estás alegre?", "Eso es excelente. Cuentame mas", "Genial, ¿Puedo saber por que?", "Eso es genial, ¿me cuentas?"};

    private String[] bancoDePalabras = {"\\bfeliz\\b", "\\balegre\\b", "\\bsuper\\b", "\\bbien\\b", "\\excelente\\b", "\\bincreible\\b", "\\bsublime\\b", "\\bsensacional\\b"}; 

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