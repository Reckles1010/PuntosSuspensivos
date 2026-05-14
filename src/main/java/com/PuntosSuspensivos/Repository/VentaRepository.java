package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.DetalleVenta;
import com.PuntosSuspensivos.Entity.Venta;
import java.time.LocalDate;
import java.util.List;

public interface VentaRepository {
    public int save(Venta venta);

    public void update(int id, int idCliente, int idEmpleado, LocalDate fechaVenta, String estadoPago);

    public void deleteVenta(int id);

    public List<Venta> findAll();

    public Venta findVenta(int id);

    public void crearTicket(int id);
}
