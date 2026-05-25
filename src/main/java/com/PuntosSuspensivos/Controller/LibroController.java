package com.PuntosSuspensivos.Controller;

import com.PuntosSuspensivos.Entity.Libro;
import com.PuntosSuspensivos.Repository.LibroRepository;
import com.PuntosSuspensivos.Repository.LibroRepositoryImpl;
import com.PuntosSuspensivos.Service.LibroService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class LibroController implements LibroRepository {
    LibroService libroService = new LibroService();

    @Override
    public void save(Libro autor) {
        libroService.save(autor);
    }

    @Override
    public void update(int id_libro, int id_autor, int id_categoria, String nombre, String isbn, String editorial, String descripcion, int año_publicacion, double precio, int stock) {
        libroService.update(id_libro, id_autor, id_categoria, nombre, isbn, editorial, descripcion, año_publicacion, precio, stock);
    }

    @Override
    public void deleteLibro(int id) {
        libroService.deleteLibro(id);
    }

    @Override
    public List<Libro> findAll() {
        return libroService.findAll();
    }

    public Libro findLibro(int id) {
        return libroService.findLibro(id);
    }
}