package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.DetalleVenta;

public interface DetalleVentaRepository {
    public void save(DetalleVenta detalleVenta);

    public void update(DetalleVenta detalleVenta);

    public DetalleVenta deleteDetalle(int id);

    public void findAll(int id);

    public DetalleVenta findDetalle(int id);
}
