package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.Normalizer;

public class Despedida extends Mensaje{
    private String[] bancoDeRespuestas = {"Aquí estaré", "Adiós", "Hasta luego", "Vuelve pronto"};
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
        return  bancoDeRespuestas[elegirRespuesta()] + ". Cuídate";
    }
 
}