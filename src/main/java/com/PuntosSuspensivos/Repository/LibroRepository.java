package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Libro;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface LibroRepository {
    public void save(Libro autor);

    public void update(int id_libro, int id_autor, int id_categoria, String nombre, String isbn, String editorial, String descripcion, int año_publicacion, double precio, int stock);

    public void deleteLibro(int id);

    public List<Libro> findAll();

    public Libro findLibro(int id);
}
