package com.PuntosSuspensivos.Entity;

import java.util.Date;
import java.util.Objects;

public class Venta {
    private static int id_general = 1;
    private int id_venta;
    private int id_cliente;
    private int id_empleado;
    private Date fecha_venta;
    private String estado_pago;

    public Venta(){
        this.id_venta = id_general;
        id_general++;
    }

    public Venta(int id_empleado, Date fecha_venta, String estado_pago) {
        this.id_cliente = id_general;
        this.id_empleado = id_empleado;
        this.fecha_venta = fecha_venta;
        this.estado_pago = estado_pago;
        id_general++;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return id_venta == venta.id_venta && id_cliente == venta.id_cliente && id_empleado == venta.id_empleado && Objects.equals(fecha_venta, venta.fecha_venta) && Objects.equals(estado_pago, venta.estado_pago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_venta, id_cliente, id_empleado, fecha_venta, estado_pago);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id_venta=" + id_venta +
                ", id_cliente=" + id_cliente +
                ", id_empleado=" + id_empleado +
                ", fecha_venta=" + fecha_venta +
                ", estado_pago='" + estado_pago + '\'' +
                '}';
    }
}
