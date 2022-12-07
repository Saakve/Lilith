package com.uv.aplication.mensajes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Problema extends Mensaje{
    private String[] bancoDeRespuestas = {"Estoy aqui para ayudarte", "Todo se puede resolver", "Es un tema delicado","Deberias reconsiderarlo, aun hay muchas oportunidades" , "No estas sola, yo estoy para ti","¿Cual es el conflicto?", "Estoy aqui, ¿puedo saber por que?", "¿como te encuentras hoy?", "Conmigo puedes estar comodo", "Debes cuidar tu salud"};

    private String[] bancoDePalabras = {"\\bproblema\\b", "\\bproblemas\\b", "\\bsuicidio\\b", "\\bsuicidarme\\b", "\\bdepresion\\b" ,"\\bconflicto\\b", "\\banorexia\\b",
    "\\besquizofrenia\\b", "\\besquizofrenico\\b", "\\bobesidad\\b"};
    private int numProblema = 0;

    public boolean verificarTipoDeMensaje(String entrada) {
        numProblema = 0;
        for (String palabra : bancoDePalabras) {
            Pattern patron = Pattern.compile(palabra, Pattern.CASE_INSENSITIVE);
            Matcher ocurrencia = patron.matcher(entrada);
            numProblema++;
            if(ocurrencia.find()) return true;
        }

        return false;
    }

    public String generarRespuesta(String entrada) {
        if(!verificarTipoDeMensaje(entrada)) return siguienteMensaje.generarRespuesta(entrada);
        return  bancoDeRespuestas[numProblema-1];
    }
 
}