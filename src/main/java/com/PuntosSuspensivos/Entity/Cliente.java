package com.PuntosSuspensivos.Entity;

import java.util.Date;
import java.util.Objects;

public class Cliente {
    private static int id_general=1;
    private int id_cliente;
    private String nombre;
    private Date fecha_nacimiento;
    private int telefono;
    private String direccion;
    private Date fecha_registro;

    public Cliente() {
        id_cliente=id_general;
        id_general++;
    }

    public Cliente(String nombre, Date fecha_nacimiento, int telefono, String direccion, Date fecha_registro){
        id_cliente=id_general;
        this.nombre=nombre;
        this.fecha_nacimiento=fecha_nacimiento;
        this.telefono=telefono;
        this.direccion=direccion;
        this.fecha_registro=fecha_registro;
        id_general++;
    }

    public int getId_general() {
        return id_general;
    }

    public void setId_general(int id_general) {
        this.id_general = id_general;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_autor() {
        return id_cliente;
    }

    public void setId_autor(int id_autor) {
        this.id_cliente = id_autor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id_cliente == cliente.id_cliente;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_cliente);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", telefono=" + telefono +
                ", direccion='" + direccion + '\'' +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
