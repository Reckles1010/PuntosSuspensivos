package com.PuntosSuspensivos.Repository;

import com.PuntosSuspensivos.Entity.Autor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AutorRepository {
    public void save(Autor autor);

    public void update(int id_autor, String nombre, String nacionalidad, LocalDate fecha_nacimiento, String biografia);

    public void deleteAutor(int id);

    public List<Autor> findAll();

    public Autor findAutor(int id);
}
