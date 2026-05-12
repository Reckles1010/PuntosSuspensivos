package com.PuntosSuspensivos.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Empleado {
    private static int id_general = 1;
    private int id_empleado;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private int telefono;
    private String email;
    private LocalDateTime fecha_registro;

    public Empleado() {
        this.id_empleado = id_general;
        id_general++;
    }

    public Empleado(String nombre, LocalDate fecha_nacimiento, int telefono, String email, LocalDateTime fecha_registro) {
        this.id_empleado = id_general;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.email = email;
        this.fecha_registro = fecha_registro;
        id_general++;
    }

    public static int getId_general() {
        return id_general;
    }

    public static void setId_general(int id_general) {
        Empleado.id_general = id_general;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id_empleado == empleado.id_empleado;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_empleado);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id_empleado=" + id_empleado +
                ", nombre='" + nombre + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", fecha_registro=" + fecha_registro +
                '}';
    }
}
