package com.PuntosSuspensivos.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Cliente {
    private int id_cliente;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private int telefono;
    private String direccion;
    private LocalDateTime fecha_registro;


    public Cliente(String nombre, LocalDate fecha_nacimiento, int telefono, String direccion){
        this.nombre=nombre;
        this.fecha_nacimiento=fecha_nacimiento;
        this.telefono=telefono;
        this.direccion=direccion;
        this.fecha_registro=fecha_registro;
    }

    public Cliente(int id_cliente, String nombre, LocalDate fecha_nacimiento, int telefono, String direccion, LocalDateTime fecha_registro){
        this.id_cliente=id_cliente;
        this.nombre=nombre;
        this.fecha_nacimiento=fecha_nacimiento;
        this.telefono=telefono;
        this.direccion=direccion;
        this.fecha_registro=fecha_registro;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
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
