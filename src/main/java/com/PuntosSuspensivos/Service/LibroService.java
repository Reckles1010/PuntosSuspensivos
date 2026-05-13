package com.PuntosSuspensivos.Service;

import com.PuntosSuspensivos.Entity.Libro;
import com.PuntosSuspensivos.Repository.LibroRepository;
import com.PuntosSuspensivos.Repository.LibroRepositoryImpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class LibroService implements LibroRepository {
    LibroRepositoryImpl libroRepository = new  LibroRepositoryImpl();

    @Override
    public void save(Libro autor){
        libroRepository.save(autor);
    }

    @Override
    public void update(int id_libro, int id_autor, int id_categoria, String nombre, String isbn, String editorial, String descripcion, int año_publicacion, double precio, int stock){
        libroRepository.update(id_libro, id_autor, id_categoria, nombre, isbn, editorial, descripcion, año_publicacion, precio, stock);
    }

    @Override
    public void deleteLibro(int id){
        libroRepository.deleteLibro(id);
    }

    @Override
    public List<Libro> findAll(){
        return libroRepository.findAll();
    }

    public Libro findLibro(int id){
        return libroRepository.findLibro(id);
    }
}
