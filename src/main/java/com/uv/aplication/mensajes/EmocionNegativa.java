package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmocionNegativa extends Mensaje {
    private String[] bancoDeRespuestas = {"¿Que te hace sentir asi?", "¿Por que te encuentras asi?", "Cuentame, me interesa ayudarte", "Animo"};

    private String[] bancoDePalabras = {"\\bfatal\\b", "\\bterrible\\b", "\\btriste\\b", "\\bmal\\b", "\\bdeprimido\\b", "\\bansiso\\b","\\binquieto\\b"};
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
        return  bancoDeRespuestas[elegirRespuesta()] + ". Todo saldra mejor, estoy aqui para escucharte";
    }
}