package com.uv.aplication.analizadores;

import com.uv.aplication.mensajes.Mensaje;

public interface IAnalizador {
    public void agregarNuevoMensaje(Mensaje mensaje);
    public void setPorDefecto(Mensaje porDefecto);
    public String generarRespuesta(String entrada);
}
