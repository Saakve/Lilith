package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Despedida extends Mensaje{
    private String[] bancoDeRespuestas = {"Aquí estaré", "Adios", "Hasta luego", "Vuelve pronto"};
    private String[] bancoDePalabras = {"\\badios\\b", "\\bhasta luego\\b", "\\bme voy\\b", "\\bnos vemos\\b", "\\bvuelvo luego\\b", "\\bme tengo que ir\\b", "\\bdebo irme\\b"};
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
        return  bancoDeRespuestas[elegirRespuesta()] + ". Cuidate";
    }
 
}