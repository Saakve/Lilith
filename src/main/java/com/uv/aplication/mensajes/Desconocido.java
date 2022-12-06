package com.uv.aplication.mensajes;

public class Desconocido extends Mensaje {
    private String[] bancoDeRespuestas = {"Cuentame mas", "¿En serio?", "Cuentame algo mas", "Te escucho", "Dime mas", "¿Y que mas?"};
     private int respuesta;
   
    private int elegirRespuesta() {
        respuesta++;
        if(respuesta > bancoDeRespuestas.length - 1) {
            respuesta %= bancoDeRespuestas.length;
        }
        return respuesta;
    }
    @Override
    public boolean verificarTipoDeMensaje(String entrada) {
        return true;
    }

    @Override
    public String generarRespuesta(String entrada) {
        return bancoDeRespuestas[elegirRespuesta()];
    }
}
