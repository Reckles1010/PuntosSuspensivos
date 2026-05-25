package com.PuntosSuspensivos.Entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Libro {
    private int id_libro;
    private int id_autor;
    private int id_categoria;
    private String nombre;
    private String isbn;
    private String editorial;
    private String descripcion;
    private int año_publicacion;
    private double precio;
    private int stock;


    public Libro(int id_autor, int id_categoria, String nombre) {
        this.id_autor=id_autor;
        this.id_categoria=id_categoria;
        this.nombre=nombre;
    }

    public Libro(int id_autor,int id_categoria, String nombre, String isbn, String editorial, String descripcion, int año_publicacion,double precio, int stock) {
        this.id_autor= id_autor;
        this.id_categoria=id_categoria;
        this.nombre=nombre;
        this.isbn=isbn;
        this.editorial=editorial;
        this.descripcion=descripcion;
        this.año_publicacion= año_publicacion;
        this.precio=precio;
        this.stock=stock;
    }

    public Libro(int id_libro, int id_autor, int id_categoria, String nombre, String isbn, String editorial, String descripcion, int año_publicacion, double precio, int stock) {
        this.id_libro=id_libro;
        this.id_autor=id_autor;
        this.id_categoria=id_categoria;
        this.nombre=nombre;
        this.isbn=isbn;
        this.editorial=editorial;
        this.descripcion=descripcion;
        this.año_publicacion=año_publicacion;
        this.precio=precio;
        this.stock=stock;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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

    public int getAño_publicacion() {
        return año_publicacion;
    }

    public void setAño_publicacion(int año_publicacion) {
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
