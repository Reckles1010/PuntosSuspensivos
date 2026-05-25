package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.DetalleVenta;

import java.util.List;

public interface DetalleVentaRepository {
    public void save(DetalleVenta detalle);

    public void  update(int id_venta, int id_libro, int cantidad, int precio);

    public void deleteVenta(int idVenta);

    public List<DetalleVenta> findAll(int idVenta);

    public DetalleVenta findDetalle(int idVenta);
}
