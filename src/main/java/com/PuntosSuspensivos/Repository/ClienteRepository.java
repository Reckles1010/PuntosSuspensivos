package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Cliente;

public interface ClienteRepository {
    public void save(Cliente cliente);

    public void update(Cliente cliente);

    public Cliente deleteCliente(int id);

    public void findAll(int id);

    public Cliente findCliente(int id);
}
