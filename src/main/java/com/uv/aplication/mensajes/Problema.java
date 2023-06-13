package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.text.Normalizer;

public class Problema extends Mensaje{
    private String[] bancoDeRespuestas = {"Estoy aquí para ayudarte", "Todo se puede resolver", "Es un tema delicado","Deberias reconsiderarlo, aún hay muchas oportunidades" , "No estas sola, yo estoy para ti","¿Cuál es el conflicto?", "Estoy aquí, ¿Puedo saber por qué?", "¿Cómo te encuentras hoy?", "Conmigo puedes estar comodo", "Debes cuidar tu salud"};

    private String[] bancoDePalabras = {"\\bproblema\\b", "\\bproblemas\\b", "\\bsuicidio\\b", "\\bsuicidarme\\b", "\\bdepresion\\b" ,"\\bconflicto\\b", "\\banorexia\\b",
    "\\besquizofrenia\\b", "\\besquizofrenico\\b", "\\bobesidad\\b"};
    private int numProblema = 0;

    public boolean verificarTipoDeMensaje(String entrada) {
        numProblema = 0;
        for (String palabra : bancoDePalabras) {
            Pattern patron = Pattern.compile(palabra, Pattern.CASE_INSENSITIVE);
            Matcher ocurrencia = patron.matcher(eliminarAcentos(entrada));
            numProblema++;
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
        return  bancoDeRespuestas[numProblema-1];
    }
 
}