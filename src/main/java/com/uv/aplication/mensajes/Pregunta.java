package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.Normalizer;

public class Pregunta extends Mensaje{
    private String[] bancoDeRespuestas = {"Lilith. Una inteligencia artificial", "Lilith", "No conozco a mis creadores","No tengo recuerdos de mi creación" , "Me creé a mi misma","estoy excelente", "Estoy bien", "No lo creo", "Había una vez una IA que ayudaba a humanos...", "Estoy aquí para ti, sientete seguro", "Cuéntame todos tus problemas", "Todo lo que quieras", "Mejor hablemos de ti", "Es mejor no dar mi opinión"};

    private String[] bancoDePalabras = {"\\bque eres\\b", "\\bquien eres\\b", "\\bquien te creo\\b", "\\bquien es tu creador\\b", "\\bcomo naciste\\b" ,"\\bcomo estas\\b", "\\bcomo te encuentras\\b", "\\beres real\\b", "\\bcuentame algo\\b", "\\bayuda\\b", "\\bproblema\\b", "\\bQue quieres que te cuente\\b", "\\by tu\\b", "\\btu que\\b"};
    private int numPregunta = 0;

    public boolean verificarTipoDeMensaje(String entrada) {
        numPregunta = 0;
        for (String palabra : bancoDePalabras) {
            Pattern patron = Pattern.compile(palabra, Pattern.CASE_INSENSITIVE);
            Matcher ocurrencia = patron.matcher(eliminarAcentos(entrada));
            numPregunta++;
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
        return  bancoDeRespuestas[numPregunta-1];
    }
 
}