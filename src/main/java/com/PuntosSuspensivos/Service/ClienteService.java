package com.PuntosSuspensivos.Service;

import com.PuntosSuspensivos.Entity.Cliente;
import com.PuntosSuspensivos.Repository.ClienteRepository;
import com.PuntosSuspensivos.Repository.ClienteRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class ClienteService implements ClienteRepository {
    ClienteRepository clienteRepositoryImpl = new ClienteRepositoryImpl();

    public void save(Cliente cliente){
        clienteRepositoryImpl.save(cliente);
    }

    public void update(int id_cliente, String nombre, LocalDate fecha_nacimiento, int telefono, String direccion){
        clienteRepositoryImpl.update(id_cliente, nombre, fecha_nacimiento, telefono, direccion);
    }

    public void deleteCliente(int id){
        clienteRepositoryImpl.deleteCliente(id);
    }

    public List<Cliente> findAll(){
        return clienteRepositoryImpl.findAll();
    }

    public Cliente findCliente(int id){
        return clienteRepositoryImpl.findCliente(id);
    }
}
