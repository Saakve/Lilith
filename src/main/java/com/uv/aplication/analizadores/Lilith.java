package com.uv.aplication.analizadores;

import org.springframework.stereotype.Component;

import com.uv.aplication.mensajes.Desconocido;
import com.uv.aplication.mensajes.Mensaje;
import com.uv.aplication.mensajes.Saludo;
import com.uv.aplication.mensajes.Presentacion;
import com.uv.aplication.mensajes.Despedida;
import com.uv.aplication.mensajes.Hecho;
import com.uv.aplication.mensajes.EmocionNegativa;
import com.uv.aplication.mensajes.EmocionPositiva;
import com.uv.aplication.mensajes.Afirmacion;
import com.uv.aplication.mensajes.Negacion;
import com.uv.aplication.mensajes.Pregunta;
import com.uv.aplication.mensajes.Gusto;
import com.uv.aplication.mensajes.Deseo;
import com.uv.aplication.mensajes.Agradecimiento;

@Component
public class Lilith implements IAnalizador {

    private Mensaje inicial;
    private Mensaje ultimo;
    private Mensaje porDefecto;

    public Lilith() {
        setPorDefecto(new Desconocido());
        agregarNuevoMensaje(new Saludo());
        agregarNuevoMensaje(new Presentacion());
        agregarNuevoMensaje(new Despedida());
        agregarNuevoMensaje(new Hecho());
        agregarNuevoMensaje(new EmocionNegativa());
        agregarNuevoMensaje(new EmocionPositiva());
        agregarNuevoMensaje(new Afirmacion());
        agregarNuevoMensaje(new Negacion());
        agregarNuevoMensaje(new Pregunta());
        agregarNuevoMensaje(new Gusto());
        agregarNuevoMensaje(new Deseo());
        agregarNuevoMensaje(new Agradecimiento());
    }

    @Override
    public void agregarNuevoMensaje(Mensaje mensaje) {
        if(inicial == null) {
            inicial = mensaje;
            ultimo = mensaje;
            ultimo.setSiguienteMensaje(porDefecto);
            return;
        }
        
        ultimo.setSiguienteMensaje(mensaje);
        ultimo = mensaje;
        ultimo.setSiguienteMensaje(porDefecto);
    }

    @Override
    public void setPorDefecto(Mensaje porDefecto) {
        this.porDefecto = porDefecto;
    }

    @Override
    public String generarRespuesta(String entrada) {
        return inicial.generarRespuesta(entrada);
    }
}
