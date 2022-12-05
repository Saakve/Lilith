package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Pregunta extends Mensaje{
    private String[] bancoDeRespuestas = {"Lilith. Una inteligencia artificial", "Lilith", "No conozco a mis creadores","No tengo recuerdos de mi creacion" , "Me cree a mi misma","estoy excelente", "Estoy bien", "No lo creo", "Habia una vez una ia que ayudaba a humanos", "Estoy aqui para ti, sientete seguro", "Cuentame todos tus problemas", "Todo lo que quieras", "Mejor hablemos de ti"};

    private String[] bancoDePalabras = {"\\bque eres\\b", "\\bquien eres\\b", "\\bquien te creo\\b", "\\bquien es tu creador\\b", "\\bcomo naciste\\b" ,"\\bcomo estas\\b", "\\bcomo te encuentras\\b", "\\beres real\\b", "\\bcuentame algo\\b", "\\bayuda\\b", "\\bproblema\\b", "\\bQue quieres que te cuente\\b", "\\by tu\\b"};
    private int respuesta;
    private int numPregunta = 0;

    public boolean verificarTipoDeMensaje(String entrada) {
        numPregunta = 0;
        for (String palabra : bancoDePalabras) {
            Pattern patron = Pattern.compile(palabra, Pattern.CASE_INSENSITIVE);
            Matcher ocurrencia = patron.matcher(entrada);
            numPregunta++;
            if(ocurrencia.find()) return true;
        }

        return false;
    }

    public String generarRespuesta(String entrada) {
        if(!verificarTipoDeMensaje(entrada)) return siguienteMensaje.generarRespuesta(entrada);
        return  bancoDeRespuestas[numPregunta-1];
    }
 
}