package com.PuntosSuspensivos.Controller;

import com.PuntosSuspensivos.Entity.Cliente;
import com.PuntosSuspensivos.Repository.ClienteRepository;
import com.PuntosSuspensivos.Service.ClienteService;

import java.time.LocalDate;
import java.util.List;

public class ClienteController implements ClienteRepository {
    ClienteService clienteService = new ClienteService();
    @Override
    public void save(Cliente cliente){
        clienteService.save(cliente);
    }

    @Override
    public void update(int id_cliente, String nombre, LocalDate fecha_nacimiento, int telefono, String direccion){
        clienteService.update(id_cliente, nombre, fecha_nacimiento, telefono, direccion);
    }

    @Override
    public void deleteCliente(int id){
        clienteService.deleteCliente(id);
    }

    @Override
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @Override
    public Cliente findCliente(int id){
        return clienteService.findCliente(id);
    }
}
