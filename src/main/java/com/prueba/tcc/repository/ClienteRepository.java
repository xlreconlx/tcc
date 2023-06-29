/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.tcc.repository;

import com.prueba.tcc.entity.Cliente;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ander
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query(value = "{ call ObtenerClientes()}", nativeQuery = true)
    public List<Cliente> obtenerClientes();

    @Modifying
    @Query(value = "{ call CrearCliente(:tipoIdentificacion, :numeroIdentificacion, :nombre, :primerApellido, :segundoApellido, :genero) }", nativeQuery = true)
    @Transactional
    public void crearCliente(String tipoIdentificacion, String numeroIdentificacion,
            String nombre, String primerApellido, String segundoApellido, String genero);

    @Modifying
    @Query(value = "{ call ActualizarCliente(:idCliente, :tipoIdentificacion, :numeroIdentificacion, :nombre, :primerApellido, :segundoApellido, :genero) }", nativeQuery = true)
    @Transactional
    public void actualizarCliente(int idCliente, String tipoIdentificacion, String numeroIdentificacion,
            String nombre, String primerApellido, String segundoApellido, String genero);
    
    @Modifying
    @Query(value = "{ call EliminarCliente(:idCliente) }", nativeQuery = true)
    @Transactional
    public void eliminarCliente(int idCliente);
    
    
    @Query(value = "{ call ObtenerClientePorID(:idCliente)}", nativeQuery = true)
    public Cliente obtenerClientePorId(int idCliente);
    
    @Query(value = "{ call ObtenerClientePorNumeroIdentificacion(:numeroIdentificacion)}", nativeQuery = true)
    public List<Cliente> obtenerClientePorNumeroIdentificacion(String numeroIdentificacion);

}
