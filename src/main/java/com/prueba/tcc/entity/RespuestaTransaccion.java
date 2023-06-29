/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tcc.entity;

/**
 *
 * @author ander
 */
public class RespuestaTransaccion {

    private boolean transaccionCompletada;
    private String mensaje;

    public RespuestaTransaccion() {
    }

    public RespuestaTransaccion(boolean transaccionCompletada, String mensaje) {
        this.transaccionCompletada = transaccionCompletada;
        this.mensaje = mensaje;
    }
    
    public boolean isTransaccionCompletada() {
        return transaccionCompletada;
    }

    public void setTransaccionCompletada(boolean transaccionCompletada) {
        this.transaccionCompletada = transaccionCompletada;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
