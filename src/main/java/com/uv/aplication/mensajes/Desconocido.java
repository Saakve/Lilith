package com.uv.aplication.mensajes;

public class Desconocido extends Mensaje {
    private String[] bancoDeRespuestas = {"Cuentame más", "¿En serio?", "Cuéntame algo más", "Te escucho", "Dime más", "¿Y qué más?"};
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

    public String eliminarAcentos(String palabra) {
        return palabra;
    }

    @Override
    public String generarRespuesta(String entrada) {
        return bancoDeRespuestas[elegirRespuesta()];
    }
}
