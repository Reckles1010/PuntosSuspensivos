package com.PuntosSuspensivos.Controller;

import com.PuntosSuspensivos.Entity.DetalleVenta;
import com.PuntosSuspensivos.Entity.Venta;
import com.PuntosSuspensivos.Service.VentaService;

import java.time.LocalDate;
import java.util.List;

public class VentaController {
    VentaService ventaService = new VentaService();

    public void save(Venta venta, List<DetalleVenta> detalles){
        ventaService.save(venta, detalles);
    }

    public void update(int id, int idCliente, int idEmpleado, LocalDate fechaVenta, String estadoPago) {
        ventaService.updateVenta(id, idCliente, idEmpleado, fechaVenta, estadoPago);
    }

    public void delete(int id) {
        ventaService.deleteVenta(id);
    }

    public List<Venta> findAll() {
        return ventaService.findAllVentas();
    }

    public Venta findVenta(int id) {
        return ventaService.findVenta(id);
    }

    public void crearTicket(int id) {
        ventaService.crearTicket(id);
    }
}
