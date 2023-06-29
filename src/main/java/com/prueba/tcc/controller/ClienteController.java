/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tcc.controller;

import com.prueba.tcc.entity.Cliente;
import com.prueba.tcc.entity.RespuestaTransaccion;
import com.prueba.tcc.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ander
 */
@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping()
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        return ResponseEntity.ok(clienteService.obtenerClientes());
    }

    @GetMapping("{idCliente}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable int idCliente) {
        return ResponseEntity.ok(clienteService.obtenerClientePorId(idCliente));
    }
    
    @PostMapping("crear")
    public ResponseEntity<RespuestaTransaccion> crearCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }
    
    @PutMapping("actualizar")
    public ResponseEntity<RespuestaTransaccion> actualizarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.actualizarCliente(cliente));
    }
    
    @DeleteMapping("eliminar/{idCliente}")
    public ResponseEntity<RespuestaTransaccion> eliminarCliente(@PathVariable int idCliente){
        return ResponseEntity.ok(clienteService.eliminarCliente(idCliente));
    }

}
