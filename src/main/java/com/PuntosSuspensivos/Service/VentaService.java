package com.PuntosSuspensivos.Service;

import com.PuntosSuspensivos.Entity.DetalleVenta;
import com.PuntosSuspensivos.Entity.Venta;
import com.PuntosSuspensivos.Repository.DetalleVentaRepository;
import com.PuntosSuspensivos.Repository.DetalleVentaRepositoryImpl;
import com.PuntosSuspensivos.Repository.VentaRepository;
import com.PuntosSuspensivos.Repository.VentaRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class VentaService{
    private final VentaRepository ventaRepository = new VentaRepositoryImpl();
    private final DetalleVentaRepository detalleRepository = new DetalleVentaRepositoryImpl();

    public int save(Venta venta, List<DetalleVenta> detalles) {
        int idVenta = ventaRepository.save(venta);

        for (DetalleVenta d : detalles) {
            d.setId_venta(idVenta);
            detalleRepository.save(d);
        }
        return idVenta;
    }


    public void updateVenta(int id, int idCliente, int idEmpleado, LocalDate fechaVenta, String estadoPago) {
        ventaRepository.update(id, idCliente, idEmpleado, fechaVenta, estadoPago);
    }

    public void deleteVenta(int id) {
        detalleRepository.deleteVenta(id);
        ventaRepository.deleteVenta(id);
    }

    public List<Venta> findAllVentas() {
        return ventaRepository.findAll();
    }

    public Venta findVenta(int id) {
        return ventaRepository.findVenta(id);
    }


    public List<DetalleVenta> findDetalles(int idVenta) {
        return detalleRepository.findAll(idVenta);
    }

    public void updateDetalle(int id_venta, int id_libro, int cantidad, int precio) {
        detalleRepository.update(id_venta, id_libro, cantidad, precio);
    }

    public void deleteDetalle(int idVenta) {
        detalleRepository.deleteVenta(idVenta);
    }

    public List<DetalleVenta> findAllDetalles(int idVenta) {
        return detalleRepository.findAll(idVenta);
    }

    public DetalleVenta findDetalle(int id_venta){
        return detalleRepository.findDetalle(id_venta);
    }

    public void crearTicket(int id) {
        ventaRepository.crearTicket(id);
    }
}