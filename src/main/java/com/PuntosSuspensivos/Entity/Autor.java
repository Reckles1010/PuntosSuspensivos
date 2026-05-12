package com.PuntosSuspensivos.Entity;

import java.util.Date;
import java.util.Objects;

public class Autor {
    private static int id_general = 1;
    private  int id_autor;
    private String nombre;
    private String nacionalidad;
    private Date fecha_nacimiento;
    private String biografia;

    public Autor(){
        this.id_autor=id_general;
        id_general++;
    }

    public Autor(String nombre, String nacionalidad, Date fecha_nacimiento, String biografia){
        this.id_autor=id_general;
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.fecha_nacimiento=fecha_nacimiento;
        this.biografia=biografia;
        id_general++;
    }

    public int getId_general() {
        return id_general;
    }

    public void setId_general(int id_general) {
        this.id_general = id_general;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id_autor == autor.id_autor;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_autor);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id_autor=" + id_autor +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", biografia='" + biografia + '\'' +
                '}';
    }
}
