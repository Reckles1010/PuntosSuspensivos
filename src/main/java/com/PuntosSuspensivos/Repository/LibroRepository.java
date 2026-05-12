package com.PuntosSuspensivos.Repository;


import com.PuntosSuspensivos.Entity.Libro;

public interface LibroRepository {
    public void save(Libro autor);

    public void update(Libro autor);

    public Libro deleteAutor(int id);

    public void findAll(int id);

    public Libro findAutor(int id);
}
