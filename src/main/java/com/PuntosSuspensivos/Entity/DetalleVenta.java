package com.PuntosSuspensivos.Entity;

public class DetalleVenta {
    private static int id_general=1;
    private int id_detalle;
    private int id_venta;
    private int id_libro;
    private int cantidad;
    private int precio;

    public DetalleVenta(){
        this.id_detalle=id_general;
        id_general++;
    }

    public DetalleVenta(int id_venta, int id_libro, int cantidad, int precio){
        this.id_venta=id_general;
        this.id_detalle=id_venta;
        this.id_venta=id_venta;
        this.id_libro=id_libro;
        this.cantidad=cantidad;
        this.precio=precio;
        id_general++;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id_detalle=" + id_detalle +
                ", id_venta=" + id_venta +
                ", id_libro=" + id_libro +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
