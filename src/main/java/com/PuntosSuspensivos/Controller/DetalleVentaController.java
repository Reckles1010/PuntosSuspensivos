package com.PuntosSuspensivos.Controller;

import com.PuntosSuspensivos.Entity.DetalleVenta;
import com.PuntosSuspensivos.Service.VentaService;

import java.util.List;

public class DetalleVentaController {
    VentaService ventaService = new VentaService();

    public void update(int id_venta, int id_libro, int cantidad, int precio) {
        ventaService.updateDetalle(id_venta, id_libro, cantidad, precio);
    }

    public void delete(int idVenta) {
        ventaService.deleteVenta(idVenta);
    }

    public List<DetalleVenta> findAll(int idVenta) {
        return ventaService.findAllDetalles(idVenta);
    }

    public DetalleVenta findDetalle(int id_venta){
        return ventaService.findDetalle(id_venta);
    }
}
