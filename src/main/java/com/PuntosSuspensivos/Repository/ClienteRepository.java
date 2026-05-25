package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Cliente;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ClienteRepository {
    public void save(Cliente cliente);

    public void update(int id_cliente, String nombre, LocalDate fecha_nacimiento, int telefono, String direccion);

    public void deleteCliente(int id);

    public List<Cliente> findAll();

    public Cliente findCliente(int id);
}
