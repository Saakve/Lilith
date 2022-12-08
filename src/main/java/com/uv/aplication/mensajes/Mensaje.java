package com.uv.aplication.mensajes;

public abstract class Mensaje {
    protected Mensaje siguienteMensaje;

    public void setSiguienteMensaje(Mensaje siguienteMensaje) {
        this.siguienteMensaje = siguienteMensaje;
    }

    public abstract String eliminarAcentos(String entrada);
    public abstract String generarRespuesta(String entrada);
    public abstract boolean verificarTipoDeMensaje(String entrada);
}
