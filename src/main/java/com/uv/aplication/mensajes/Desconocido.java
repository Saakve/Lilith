package com.uv.aplication.mensajes;

public class Desconocido extends Mensaje {
    private String[] bancoDeRespuestas = {"No entendí lo que quieres decir"};

    @Override
    public boolean es(String entrada) {
        return true;
    }

    @Override
    public String generarRespuesta(String entrada) {
        return bancoDeRespuestas[0];
    }
}
