package com.PuntosSuspensivos.Entity;

import java.util.Date;
import java.util.Objects;

public class Libro {
    private static int id_general;
    private int id_libro;
    private int id_autor;
    private int id_categoria;
    private String nombre;
    private int isbn;
    private String editorial;
    private String descripcion;
    private Date año_publicacion;
    private double precio;
    private int stock;

    public Libro() {
        this.id_libro=id_general;
        id_general++;
        this.stock=20;
    }

    public Libro(int id_autor, int id_categoria, String nombre) {
        this.id_libro=id_general;
        this.id_autor=id_autor;
        this.id_categoria=id_categoria;
        this.nombre=nombre;
        id_general++;
    }

    public Libro(int id_autor, int id_categoria, String nombre, int isbn, String editorial, String descripcion, Date año_publicacion,double precio, int stock) {
        this.id_libro=id_general;
        this.id_autor=id_autor;
        this.id_categoria=id_categoria;
        this.nombre=nombre;
        this.isbn=isbn;
        this.editorial=editorial;
        this.descripcion=descripcion;
        this.año_publicacion=año_publicacion;
        this.precio=precio;
        this.stock=stock;
        id_general++;
    }

    public static int getId_general() {
        return id_general;
    }

    public static void setId_general(int id_general) {
        Libro.id_general = id_general;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(Date año_publicacion) {
        this.año_publicacion = año_publicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id_libro == libro.id_libro;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_libro);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id_libro=" + id_libro +
                ", id_autor=" + id_autor +
                ", id_categoria=" + id_categoria +
                ", nombre='" + nombre + '\'' +
                ", isbn=" + isbn +
                ", editorial='" + editorial + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", año_publicacion=" + año_publicacion +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
