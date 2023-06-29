/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tcc.service;

import com.prueba.tcc.entity.Cliente;
import com.prueba.tcc.entity.RespuestaTransaccion;
import com.prueba.tcc.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ander
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerClientes() {
        return clienteRepository.obtenerClientes();
    }

    public Cliente obtenerClientePorId(int idCliente) {
        return clienteRepository.obtenerClientePorId(idCliente);
    }
    
    public List<Cliente> obtenerClientePorNumeroIdentificacion(String numeroIdentificacion){
        return clienteRepository.obtenerClientePorNumeroIdentificacion(numeroIdentificacion);
    }

    public RespuestaTransaccion crearCliente(Cliente cliente) {
        RespuestaTransaccion respuestaTransaccion = new RespuestaTransaccion();
        try {
            if (obtenerClientePorNumeroIdentificacion(cliente.getNumeroIdentificacion()).isEmpty()) {
                clienteRepository.crearCliente(cliente.getTipoIdentificacion(), cliente.getNumeroIdentificacion(), cliente.getNombre(), cliente.getPrimerApellido(), cliente.getSegundoApellido(), cliente.getGenero());
                respuestaTransaccion.setTransaccionCompletada(true);
                respuestaTransaccion.setMensaje("Se registro correctamente al nuevo Cliente");
                return respuestaTransaccion;
            } else {
                respuestaTransaccion.setTransaccionCompletada(false);
                respuestaTransaccion.setMensaje("Ya existe un cliente con ese numero de identificacion");
                return respuestaTransaccion;
            }

        } catch (Exception exception) {
            respuestaTransaccion.setTransaccionCompletada(false);
            respuestaTransaccion.setMensaje("Ocurrio un error registrando al nuevo Cliente: " + exception.toString());
            return respuestaTransaccion;
        }
    }

    public RespuestaTransaccion actualizarCliente(Cliente cliente) {
        RespuestaTransaccion respuestaTransaccion = new RespuestaTransaccion();
        try {
            List<Cliente> listaClientes = obtenerClientePorNumeroIdentificacion(cliente.getNumeroIdentificacion());
            boolean existeCliente = false;
            for (Cliente clienteItem : listaClientes) {
                if (clienteItem.getIdCliente() != cliente.getIdCliente()) {
                    existeCliente = true;
                }
            }

            if (existeCliente) {
                respuestaTransaccion.setTransaccionCompletada(false);
                respuestaTransaccion.setMensaje("Ya existe un cliente con ese numero de identificacion");
                return respuestaTransaccion;
            }

            clienteRepository.actualizarCliente(cliente.getIdCliente(), cliente.getTipoIdentificacion(), cliente.getNumeroIdentificacion(), cliente.getNombre(), cliente.getPrimerApellido(), cliente.getSegundoApellido(), cliente.getGenero());
            respuestaTransaccion.setTransaccionCompletada(true);
            respuestaTransaccion.setMensaje("Se ha actualizado correctamente");
            return respuestaTransaccion;
        } catch (Exception exception) {
            respuestaTransaccion.setTransaccionCompletada(false);
            respuestaTransaccion.setMensaje("Ocurrio un error actualizando al Cliente: " + exception.toString());
            return respuestaTransaccion;
        }
    }

    public RespuestaTransaccion eliminarCliente(int idCliente) {
        RespuestaTransaccion respuestaTransaccion = new RespuestaTransaccion();
        try {
            clienteRepository.eliminarCliente(idCliente);
            respuestaTransaccion.setTransaccionCompletada(true);
            respuestaTransaccion.setMensaje("Se ha eliminado correctamente");
            return respuestaTransaccion;
        } catch (Exception exception) {
            respuestaTransaccion.setTransaccionCompletada(false);
            respuestaTransaccion.setMensaje("Ocurrio un error eliminando al Cliente: " + exception.toString());
            return respuestaTransaccion;
        }
    }

}
